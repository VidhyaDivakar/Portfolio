# Registry: Clarify and document registryType possible values #7871

## Issue description

In the context of adding new entries to the Registry, we currently haven't documented the possible values and their definitions for the registryType attribute, which may cause contributors uncertainty when choosing the right value.

**What are Registry?**
Registry is a repository where you can find libraries, plugins, utilities, metric collectors, integrations and tools for working with the OpenTelemetry ecosystem. Consider affixing to the registry only if you provide external integration of OpenTelemetry for any kind of library, service, or app.

**What are Registry Type?**
Registry Type defines the type of Registry that you are are going to integrate to OpenTelemetry.To add a registry with our systems, you need to work on a [data file](#data_file) is present in data/registry folder Each registryType tells the system how to integrate that component with the rest of the telemetry pipeline.
<u>**Registry Types and Definitions**</u>

### 1. Application Integration

Application Integration in OpenTelemetry ensures that telemetry data from multiple sources (services, instrumentation, collectors) is natively integrate/unified within the observability pipeline. In the data file, `registryType` field identifies the type of component being integrated.

Following are few of the scenarios where the contributors' projects falls under the category Application Integration.

- Adds an OpenTelemetry Collector to all Linux VMs to egress metrics and traces.
- Heroku Fir adds platform-native support for the collection and distribution of
  OpenTelemetry signals.
- It allows you to export ThousandEyes telemetry data in OTel format.
- ClickHouse creates `trace spans` for each query and some of the query execution stages, such as query planning or distributed queries.
- The OpenTelemetry tracing sandbox demonstrates Envoy's request tracing capabilities using OpenTelemetry as the tracing provider.
- Argo Workflows provides native OpenTelemetry metrics to provide information from the workflow controller.
- containerd supports OpenTelemetry tracing since v1.6.0. Tracing currently targets only gRPC calls.
- Cortex uses Jaeger or OpenTelemetry to implement distributed tracing.
- The `crio.tracing` table containers settings pertaining to the export of OpenTelemetry trace data.
- Dapr directly writes traces using the OpenTelemetry (OTLP) protocol as the recommended method.
- Keycloak utilizes OpenTelemetry for distributed tracing provided by the Quarkus OpenTelemetry extension.
- The MLflow tracing feature is built using OpenTelemetry, and allows users to trace the execution of their generative AI applications.

### 2. Core

 Core Registry Type refers to integrating otel's core components, such as integrated CLI tool in for use with the collector builder, Otel SDK's, APIs, standard protocols, Instrumentation Libraries and the like. This is never applicable to non-project components.

Following are few of the scenarios where the contributors' projects falls under the category Core:

- A CLI tool that generates OpenTelemetry Collector binaries based on a manifest.

### 3. Utility

Utility Registry Type refers to any tool that helps to improve the observability and monitoring, which in turn improves system performance, efficiency, network security etc.,
Following are few of the scenarios where the contributors' projects falls under the category utility:

- Collector Supervisor for OpAMP

### 4. Provider

A Provider Registry Type can be a component that enables the Collector to fetch configuration values such as appsettings.json, CLI arguments, API keys, other sensitive/confidential data from external sources. These providers helps to securely manage the configuration for many collectors from a centrally-managed web server also encrypts, protect the data while transit.

Following are few of the scenarios where the contributors' projects falls under the category Provider:

- Environment variable provider for OpenTelemetry Collector configuration maps such as powershell, web applications, cloud platforms
- File provider for OpenTelemetry Collector configuration maps.
- Google Secret Manager provider for OpenTelemetry Collector configuration maps.
- HTTP provider for OpenTelemetry Collector configuration maps.
- YAML provider for OpenTelemetry Collector configuration maps.

### 5. Exporter

Exporter Registry Type refers to either an exporter component of the collector, or an exporter within a language-specific SDK, not applicable for a 3rd party component that is exporting telemetry.

Following are few of the scenarios where the contributors' projects falls under the category Exporter:

- Exports OTel Events (SpanEvent in Tracing added by AddEvent API) as Alerts to [Alertmanager](https://prometheus.io/docs/alerting/latest/alertmanager/) backend to notify Errors or Change events.
- The Alibaba Cloud Log Service Exporter for the OpenTelemetry Collector.
- Exports traces and/or metrics via HTTP to an APIClarity endpoint for analysis.
- The AWS X-Ray Tracing Exporter for the OpenTelemetry Collector.
- AWS CloudWatch Logs Exporter sends logs data to AWS CloudWatch Logs
- The AWS CloudWatch EMF Exporter for the OpenTelemetry Collector.
- The OpenTelemetry Kinesis Exporter for Go.
- This exporter targets to support proto/JSON and proto/binary format
- The Azure Monitor Exporter for the OpenTelemetry Collector.
- This exporter supports sending traces, metrics, and logs data to [Azure Blob storage] (<https://learn.microsoft.com/en-us/azure/storage/blobs/storage-blobs-overview>).
- This exporter sends metrics, logs and trace data to Azure Data Explorer
- The Carbon Exporter for the OpenTelemetry Collector.

### 6. Extension

Extensions are referred to as collectors or SDK extension that add capabilities to the agent without having to create a separate Otel distribution. Extensions are designed to override or customize the instrumentation provided by the upstream agent.

Following are few of the scenarios where the contributors' projects falls under the category Extension:

- Client Authentication extension allows acknowledging  of data upon successful processing. The upstream agent can choose to send event again if ack fails.
- Basic Authentication extension provides Atlassian Service Authentication Protocol (ASAP) client credentials for HTTP or gRPC based exporters.
- The Bearer token authenticator extension allows gRPC and HTTP-based exporters to add authentication data to outgoing calls based on a static token.
- The Datadog Extension for the OpenTelemetry Collector.

### 7. Instrumentation

 Instrumentation Registry type can be done manually, with SDKs and APIs, or automatically using agents or other code manipulation techniques.  e act of adding code to a system to collect data about its internal state and behavior, which includes traces, metrics, and log.

 Following are few of the scenarios where the contributors' projects falls under the category Instrumentation:

- gRPC provides support for an OpenTelemetry plugin that provides metrics
- httpd (Apache) OpenTelemetry module to add OpenTelemetry distributed tracing support to httpd.
- The `ngx_otel_module` dynamic module enables NGINX Open Source or NGINX Plus to send telemetry data to an OTel collector.
- The OTel web server module comprises of both Apache HTTP Server and NGINX instrumentation.
- The ASP.NET Telemetry HttpModule enables distributed tracing of incoming ASP.NET requests using the OpenTelemetry API.

### 8. Log-bridge

 Log-Bridge Registry Type refers to implementing log-bridge, a component to make your existing logging framework to be compatible with Otel Log.

Following are few of the scenarios where the contributors' projects falls under the category Log-bridge:

- Package otellogrus provides an OpenTelemetry log bridge for `github.com/sirupsen/logrus`.
- Package otelslog provides an OpenTelemetry log bridge for `log/slog`.
- Package otelzap provides an OpenTelemetry log bridge for `go.uber.org/zap`.
- MonoLog Log Appender for PHP.

### 9. Processor

Processor is a type of Registry that helps to collect data from the external sources and make it adaptable/readable by the Otel Collector.

Following are the few scenarios where processors implemented with Otel.

- The Span Processor for the OpenTelemetry Collector modifies either the span name or attributes of a span based on the span name.
- The logs transform processor can be used to apply log operators to logs coming from any receiver.
- The K8s Attribute Processor for the OpenTelemetry Collector automatically discovers K8s resources (pods), extracts metadata from them and adds the   extracted metadata to the relevant spans, metrics and logs.
- The delta to cumulative processor (`deltatocumulativeprocessor`) converts metrics from delta temporality to cumulative, by accumulating samples in memory.

### 10. Receiver

Receiver Registry type refers to the collector component "receiver", not applicable for 3rd party components that are receiving otel telemetry.

Following are the few scenarios where processors implemented with Otel.

- The active_directory_ds receiver scrapes metric relating to an Active Directory domain controller using the Windows Performance Counters.
- The Aerospike receiver is designed to collect performance metrics from one or more Aerospike nodes.

### 11. Resource Detector

Resource Detectors for language specific SDKs. This type of registry component, Resource detectors gather metadata about this entity from various sources.

Following are few of the scenarios where the contributors' projects falls under the category Resource Detector:

## Glossary

### data_file

You can find the data file, in the following location <<https://github.com/open-telemetry/opentelemetry.io/tree/main/data/registry>

// This is a new topic worked for an issue raised in OpenTelemetry. This gave me good experience how to work on gitup issues. Need to work on more.
