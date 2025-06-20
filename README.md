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

---

## 🧱 Stack Tecnologico

### 🌐 Frontend – Flutter (Mobile)

- **Flutter 3.22**, **Dart 3.3**
- **State Management**: Riverpod 3 + hooks
- **Routing**: GoRouter
- **Networking**: Dio (interceptor, retry)
- **Forms**: flutter_form_builder, reactive_forms
- **Autenticazione**: Firebase Auth + OAuth (Google, Apple)
- **Push Notification**: Firebase Cloud Messaging (FCM)
- **Storage Locale**: Hive + flutter_secure_storage
- **Media**: image_picker, cached_network_image
- **Testing**: flutter_test, integration_test, widget test con Mockito
- **Internazionalizzazione**: flutter_localizations, intl
- **Accessibilità**: Supporto screen reader e semantics widgets

### 🛠 Backend – Spring Boot

- **Java 21**, **Spring Boot 3.1**
- **Database**: PostgreSQL 15+
- **Storage immagini**: MinIO o AWS S3 (upload via presigned URLs)
- **Autenticazione**:
  - JWT con refresh token e scopes
  - Delegation OAuth via Firebase (OIDC)
- **API**: REST (OpenAPI 3.1)
- **Scheduling**: Spring Scheduler
- **Sicurezza**: Spring Security, CORS, validazioni input, rate limiting
- **Monitoring**: Micrometer + Prometheus + Grafana
- **Logging**: Logback, logging strutturato
- **Container**: Docker multi-stage build (ARM/x86_64)
- **Testing**: Unit, integration e contract testing con Mockito + Testcontainers

### ☁️ Infrastruttura & DevOps

- **Kubernetes** (GKE, EKS o self-hosted)
- **CI/CD**: GitLab CI + GitOps (GitLab Kubernetes Agent)
- **Helm**: Charts per deployment configurabili
- **Secrets Management**: Kubernetes Secrets con crittografia abilitata
- **Monitoring & Logging**: Prometheus + Grafana, log su stdout
- **Network Security**: Ingress controller con TLS (cert-manager)

## 🔜 Tecnologie e Feature da Rimandare (Post-MVP)

Le seguenti funzionalità non sono necessarie per la prima versione dell’applicazione e potranno essere implementate successivamente:

### 🔧 Frontend
- Supporto **OAuth Facebook**
- Supporto a **WebP** per compressione immagini
- **Geolocalizzazione** (geolocator, flutter_map / Google Maps SDK)

### 🌐 Backend
- **GraphQL** (Spring GraphQL)
- **Realtime** tramite WebSocket o SSE (per ora polling)
- **OpenTelemetry** per tracing distribuito
- **Log centralizzati** (ELK stack o Loki)
- **HashiCorp Vault** per gestione avanzata dei secrets
- **Backup avanzato** (Velero, pgBackRest, Barman)
- **API Gateway**: Kong / Traefik per rate limiting e autenticazione centralizzata
- **Autoscaling avanzato**: HPA e VPA
- **Alerting automatico** via Slack/email/webhook
- **Cost monitoring** e ottimizzazione risorse cloud

## 📈 Roadmap

- ✅ MVP (prenotazioni, autenticazione, servizi, notifiche)
- 🔜 Real-time updates via WebSocket
- 🔜 Dashboard Admin con statistiche e analytics
- 🔜 Appuntamenti geolocalizzati con mappa
- 🔜 Supporto a sedi multiple / catene
- 🔜 Intelligenza artificiale per suggerimenti orari/servizi

---

