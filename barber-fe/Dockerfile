FROM cirrusci/flutter:3.22.0 AS builder

WORKDIR /app

COPY pubspec.* ./
RUN flutter pub get

COPY . .

RUN flutter build apk --release

# Optional AAB
# RUN flutter build appbundle --release

# Stage 2: Export build artifacts
FROM alpine:3.20 AS exporter

WORKDIR /output
COPY --from=builder /app/build/app/outputs/flutter-apk/app-release.apk ./

# Optional:
# COPY --from=builder /app/build/app/outputs/bundle/release/app-release.aab ./
