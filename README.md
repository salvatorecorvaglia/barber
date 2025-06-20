# 💈 Barber

**Barber** è un'applicazione **mobile cross-platform (iOS e Android)** pensata per modernizzare la gestione di barberie. Grazie a una piattaforma integrata, permette a clienti, barbieri e amministratori di interagire in tempo reale, ottimizzando la prenotazione, la gestione dei servizi e l’analisi delle performance.

## ✨ Funzionalità Principali

### 👤 Clienti
- Prenotazione di appuntamenti in tempo reale
- Visualizzazione servizi, prezzi e disponibilità
- Gestione del profilo utente
- Notifiche push per conferme, modifiche e reminder

### 💼 Barbieri / Staff
- Visualizzazione e gestione degli appuntamenti
- Aggiornamento disponibilità e calendario
- Ricezione notifiche in tempo reale
- Upload e gestione immagini portfolio

### 🛠️ Amministratori
- Configurazione di servizi, orari, giorni di chiusura
- Analisi statistiche dettagliate (prenotazioni, clienti, ricavi)
- Gestione team e disponibilità
- Dashboard con metriche e grafici real-time

## 🧱 Stack Tecnologico

### 🌐 Frontend – Flutter (Mobile)

- **Flutter 3.22**, **Dart 3.3**
- **State Management**: Riverpod 3 + hooks
- **Routing**: GoRouter
- **Networking**: Dio (interceptor, retry)
- **Forms**: flutter_form_builder, reactive_forms
- **Autenticazione**: Firebase Auth + OAuth (Google, Apple, Facebook)
- **Push Notification**: Firebase Cloud Messaging (FCM)
- **Storage Locale**: Hive + flutter_secure_storage
- **Media**: image_picker, cached_network_image, WebP
- **Geolocalizzazione**: geolocator, flutter_map / Google Maps SDK
- **Testing**: flutter_test, integration_test, widget test con Mockito
- **Internazionalizzazione**: flutter_localizations, intl
- **Accessibilità**: Supporto screen reader e semantics widgets

### 🛠 Backend – Spring Boot

- **Java 21**, **Spring Boot 3.1**
- **Database**: PostgreSQL 15+
- **Storage**: MinIO o AWS S3
- **Autenticazione**:
  - JWT con refresh token e scopes
  - Delegation OAuth via Firebase (OIDC)
- **API**: REST (OpenAPI 3.1), opzione GraphQL (Spring GraphQL)
- **Realtime**: WebSocket o SSE
- **Upload Immagini**: Presigned URLs
- **Scheduling**: Spring Scheduler
- **Sicurezza**: Spring Security, CORS, validazioni input, rate limiting
- **Monitoraggio**: Micrometer + Prometheus + Grafana + OpenTelemetry
- **Logging**: Logback/Log4j2, JSON logging, ELK stack o Loki
- **Container**: Docker multi-stage build per ARM/x86_64
- **Testing**: Unit, integration, contract testing con Mockito + Testcontainers

---

## ☁️ Infrastruttura & DevOps

- **Kubernetes** (GKE, EKS o self-hosted)
- **CI/CD**: GitLab CI + GitOps (GitLab Kubernetes Agent)
- **Helm**: Charts per deployment configurabili
- **Secrets Management**: HashiCorp Vault o Kubernetes Secrets
- **Autoscaling**: HPA e VPA
- **Backup & Restore**:
  - Velero (Kubernetes)
  - pgBackRest / Barman (PostgreSQL)
- **API Gateway**: Kong, Traefik o NGINX Ingress
- **Network Security**: Network policies + TLS (cert-manager)
- **Storage HA**: MinIO distribuito o AWS S3
- **Logging/Monitoring**: ELK stack o Loki + Prometheus + Grafana
- **Alerting**: Slack, email, webhook
- **Cost Optimization**: Strumenti di analisi costi cloud