# 💈 Barber

**Barber** is a **cross-platform mobile app (iOS and Android)** designed to modernize barber shop management. Thanks to an integrated platform, it allows customers, barbers, and administrators to interact in real time, optimizing appointment booking, service management, and performance analysis.

## ✨ Main Features

### 👤 Customers
- Real-time appointment booking
- Viewing services, prices, and availability
- User profile management
- Push notifications for confirmations, changes, and reminders

### 💼 Barbers / Staff
- Viewing and managing appointments
- Updating availability and calendar
- Receiving real-time notifications
- Uploading and managing portfolio images

### 🛠️ Administrators
- Configuring services, hours, and closed days
- Detailed statistical analysis (bookings, customers, revenue)
- Managing team and availability
- Dashboard with real-time metrics and charts

## 🧱 Technology Stack

### 🌐 Frontend – Flutter (Mobile)

- **Flutter 3.22**, **Dart 3.3**
- **State Management**: Riverpod 3 + hooks
- **Routing**: GoRouter
- **Networking**: Dio (interceptors, retry)
- **Forms**: flutter_form_builder, reactive_forms
- **Authentication**: Firebase Auth + OAuth (Google, Apple)
- **Push Notifications**: Firebase Cloud Messaging (FCM)
- **Local Storage**: Hive + flutter_secure_storage
- **Media**: image_picker, cached_network_image
- **Testing**: flutter_test, integration_test, widget tests with Mockito
- **Internationalization**: flutter_localizations, intl
- **Accessibility**: Screen reader support and semantics widgets

### 🛠 Backend – Spring Boot

- **Java 24**, **Spring Boot 3.5.3**
- **Database**: PostgreSQL 15+
- **Image Storage**: MinIO or AWS S3 (upload via presigned URLs)
- **Authentication**:
  - JWT with refresh token and scopes
  - OAuth delegation via Firebase (OIDC)
- **API**: REST (OpenAPI 3.1)
- **Scheduling**: Spring Scheduler
- **Security**: Spring Security, CORS, input validations, rate limiting
- **Monitoring**: Micrometer + Prometheus + Grafana
- **Logging**: Logback, structured logging
- **Container**: Multi-stage Docker build (ARM/x86_64)
- **Testing**: Unit, integration, and contract testing with Mockito + Testcontainers

### ☁️ Infrastructure & DevOps

- **Kubernetes** (GKE, EKS, or self-hosted)
- **CI/CD**: GitLab CI + GitOps (GitLab Kubernetes Agent)
- **Helm**: Configurable deployment charts
- **Secrets Management**: Kubernetes Secrets with encryption enabled
- **Monitoring & Logging**: Prometheus + Grafana, logs on stdout
- **Network Security**: Ingress controller with TLS (cert-manager)

## 🔜 Technologies and Features to Postpone (Post-MVP)

The following features are not required for the first app version and can be implemented later:

### 🔧 Frontend
- Support for **OAuth Facebook**
- Support for **WebP** image compression
- **Geolocation** (geolocator, flutter_map / Google Maps SDK)

### 🌐 Backend
- **GraphQL** (Spring GraphQL)
- **Realtime** via WebSocket or SSE (polling for now)
- **OpenTelemetry** for distributed tracing
- **Centralized Logging** (ELK stack or Loki)
- **HashiCorp Vault** for advanced secrets management
- **Advanced Backups** (Velero, pgBackRest, Barman)
- **API Gateway**: Kong / Traefik for centralized rate limiting and authentication
- **Advanced Autoscaling**: HPA and VPA
- **Automatic Alerting** via Slack/email/webhook
- **Cost Monitoring** and cloud resource optimization

## 📈 Roadmap

- ✅ MVP (booking, authentication, services, notifications)
- 🔜 Real-time updates via WebSocket
- 🔜 Admin dashboard with statistics and analytics
- 🔜 Geolocated appointments with map
- 🔜 Support for multiple locations / chains
- 🔜 Artificial intelligence for schedule/service suggestions