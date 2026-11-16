---
name: project-kafka-visual-learning
description: "Kafka Visual Learning Platform — single-file HTML on Desktop, 25+ modules, 15+ animations, interview Q&A, production monitoring, enhanced CLI section, lifecycle white theme."
metadata: 
  node_type: memory
  type: project
  originSessionId: dfc53a01-03ec-4a28-9137-77ab00a53c20
---

Single-file interactive learning platform at `Desktop/kafka-visual-learning.html`.

**Why:** User is learning Apache Kafka and building this as a comprehensive visual reference. Each session adds new plain-English pointwise explanation blocks, sections, and UI enhancements in response to screenshots of existing sections.

**How to apply:** When user shares a screenshot of a section and asks to "explain" it — insert a new white-bg `SIMPLE EXPLANATION` block directly in the HTML, immediately above or below the section shown. Never replace existing content.

---

## File stats
- Path: `/Users/karanrajsinha/Desktop/kafka-visual-learning.html`
- Size: ~12,000+ lines, 550KB+
- Stack: Bootstrap 5.3.3, GSAP 3, Chart.js 4, Google Fonts (Inter + Poppins + JetBrains Mono)

## Key section IDs
| Section | ID | Notes |
|---|---|---|
| Message Lifecycle Animation | `#lifecycle` | ~line 636, 11-step SVG animation |
| Message Lifecycle Step Breakdown | static below `#lifecycle` | ~line 1790, now fully white theme (outer + all 11 inner cards) |
| Topic Anatomy | `#topic-anatomy` | ~line 2420, 8 concept cards + pointwise explainer added |
| Producer→Topic→Consumer Relationship | `#relationship` | ~line 2628 |
| Failure Scenarios | `#failure-scenarios` | ~line 2935, 3 scenarios + pointwise explainer added |
| Producer Internals | `#producer` | ~line 3267, config explainer converted to white bg |
| Consumer Internals | `#consumer` | ~line 4645, offset commit explainer + consumer grouping section added |
| Consumer Grouping (new section) | after `#consumer` | ~line 5461 |
| Replication | `#replication` | ~line 5676 |
| Delivery Semantics | `#delivery` | ~line 7140, Swiggy/Zomato examples added |
| Spring Boot Code | `#springboot` | 12-pane JS-switched tabs: OrderController, CreateOrderRequest, OrderEvent, OrderService, OrderProducer, PaymentConsumer, PaymentService, PaymentEvent, NotificationConsumer, NotificationService, KafkaConfig, application.yml |
| Interview Q&A | `#interview` | JS-driven accordion, ~200Q per tab, 4 tabs: core/prodcons/advanced/sysdesign, live search |
| Production Monitoring | `#prodmonitoring` | New section: 6 tabs (lag/broker/dlt/perf/data/ops), ~34 enterprise P1/P2/P3 scenarios, live search |
| CLI Commands / Resources | `#resources` | 3 gradient command cards (indigo/emerald/orange), 6 metric cards, internal topics card, config/admin card, copy buttons |

## Major enhancements added (cumulative, latest session)

### Spring Boot Code Tab (12 panes)
Complete production pipeline: HTTP POST → OrderController → OrderService (DB persist) → OrderProducer (KafkaTemplate) → PaymentConsumer (MANUAL ack + idempotency) → PaymentService → NotificationConsumer → NotificationService. KafkaConfig creates NewTopics (6p/RF=3), DLTs, two ConcurrentKafkaListenerContainerFactory beans with DefaultErrorHandler + DeadLetterPublishingRecoverer + FixedBackOff(1000L,3).

### Interview Q&A (~800 questions total)
JS data structure `IQ_DATA` with 4 keys: `core`, `prodcons`, `advanced`, `sysdesign`. Each question: `{l:'B'|'I'|'A', q:'...', a:'...'}`. Rendered via `renderIQTab(tabKey)`, filtered via `filterIQ(val)`. Bootstrap accordion markup generated dynamically.

### Production Monitoring Section
`PM_DATA` JS object: 6 keys × 5-7 scenarios. Each scenario: `{sev:'P1'|'P2'|'P3', title:'...', body:'...HTML...'}`. Custom toggle (not Bootstrap accordion) via `togglePM(id,btn)`. CSS classes: `.pm-card`, `.pm-btn`, `.pm-body.open`, `.pm-sev-p1/p2/p3`.

### CLI Commands Section
3 gradient command cards: indigo (`#1e1b4b→#312e81`), emerald (`#064e3b→#065f46`), orange (`#7c2d12→#9a3412`). Font: JetBrains Mono at .82rem. Copy buttons via `navigator.clipboard.writeText()`.

### Message Lifecycle White Theme (fully complete)
Outer section + all 11 inner step cards converted from dark to light:
- Outer cards: `background:#ffffff` + `border:1.5px solid #e2e8f0` + subtle shadow
- Blue step headers: `background:#eff6ff` border `#bfdbfe`
- Purple step headers: `background:#f5f3ff` border `#ddd6fe`
- Orange step headers: `background:#fff7ed` border `#fed7aa`
- "In Plain English" boxes: `background:#eff6ff` border `#bfdbfe`
- "Why It Matters" boxes: `background:#f0fdf4` border `#86efac`
- Token column text: `color:#1d4ed8` (was `#fbbf24`)
- Body text: `color:#334155` (was `#e2e8f0`)
- Code blocks: kept dark (`background:#0f172a`) — always dark per design standard

## Design conventions for added sections
- Outer wrapper: `background:#fff; border:1.5px solid #e2e8f0; border-radius:16px; padding:2rem; box-shadow:0 2px 16px rgba(0,0,0,.06)`
- Section badge: `background:#fef3c7; color:#92400e; border:1px solid #fde68a; border-radius:999px` with text "SIMPLE EXPLANATION"
- Each concept card: colored border matching topic (blue=producer, purple=broker, orange=consumer, red=error, green=success)
- Code blocks stay dark (`#0f172a`) even inside light cards
- Analogies in italic grey at top of each card

## Sections with pointwise explainers added (cumulative)
1. Message Lifecycle — 11 steps static breakdown (fully white themed)
2. Log line decoder — static decoder panel
3. Topic Anatomy — 8 concepts
4. Failure Scenarios — 3 scenarios
5. Producer Configs — 8 configs (white bg)
6. Offset Commit Strategies — AUTO / commitSync / commitAsync
7. Consumer Grouping — coordinator, 4 failure types, rebalance storm
8. Delivery Semantics — At-Most-Once / At-Least-Once / Exactly-Once with examples

## Kafka color conventions in diagrams
- Blue (#3b82f6) = Producer side
- Purple (#8b5cf6) = Broker / Kafka internals
- Orange (#f97316) = Consumer side
- Green (#10b981) = Success / ISR / ACK
- Red (#ef4444) = Error / failure
