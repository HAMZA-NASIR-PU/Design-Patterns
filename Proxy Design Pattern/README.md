# Proxy Design Pattern

The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder object to control access to another object. This can help manage resource-intensive objects, provide access control, logging, or lazy initialization.

## Types of Proxy Patterns

- `Virtual Proxy`: Used when creating an expensive object on demand (lazy initialization).

- `Protection Proxy`: Controls access to the original object, useful in scenarios where objects should have different access rights.

- `Remote Proxy`: Used when the object being proxied is in a different address space (e.g., across a network).

- `Cache Proxy`: Adds caching behavior to avoid duplicate calls for costly or time-consuming operations.