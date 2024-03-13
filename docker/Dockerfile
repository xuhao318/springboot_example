FROM busybox

ARG BUILD_PLATFORM="linux/amd64"
ARG BUILDER_IMAGE="golang:1.20.6-alpine3.18"

FROM --platform=$BUILD_PLATFORM $BUILDER_IMAGE as builder

WORKDIR /
COPY . ./

# Get Signer plugin binary
ARG SIGNER_BINARY_LINK="https://d2hvyiie56hcat.cloudfront.net/linux/amd64/plugin/latest/notation-aws-signer-plugin.zip"
ARG SIGNER_BINARY_FILE="notation-aws-signer-plugin.zip"
RUN apk update && \
    apk add sudo wget unzip && \
    wget -O ${SIGNER_BINARY_FILE} ${SIGNER_BINARY_LINK} && \
    unzip -o ${SIGNER_BINARY_FILE} 

RUN apt-get update && \
     apt-get install -y --allow-unauthenticated yamllint

RUN apk update && \
    apk add --no-cache --allow-untrusted curl


# Build Go binary
RUN GOOS=linux GOARCH=amd64 CGO_ENABLED=0 go build -ldflags="-w -s" -o kyverno-notation-aws .

FROM gcr.io/distroless/static:nonroot
WORKDIR /

# Install sudo in the final image
RUN apk --no-cache add sudo

# Notation home
ENV PLUGINS_DIR=/plugins

COPY --from=builder notation-com.amazonaws.signer.notation.plugin plugins/com.amazonaws.signer.notation.plugin/notation-com.amazonaws.signer.notation.plugin

COPY --from=builder kyverno-notation-aws kyverno-notation-aws
ENTRYPOINT ["sudo", "/kyverno-notation-aws"]
