
### 🔒 **Restrictions on Record Classes**

1. **No `extends` clause**:

    * A record **cannot extend any class**, not even `Record`.
    * Its **implicit superclass is always `java.lang.Record`**.

2. **Implicitly final and non-abstract**:

    * A record is **final** by default and **cannot be abstract**.
    * Prevents subclassing and emphasizes immutability.

3. **Immutable fields**:

    * Record components are compiled into **final fields**.
    * You **cannot declare additional instance fields** or use **instance initializers**.

4. **Cannot declare native methods**:

    * Prevents reliance on external state; ensures full state is in the record header.

5. **Explicit member declarations must match**:

    * If you override automatically generated methods (e.g., accessors, `equals`, `hashCode`), types must match exactly.
    * Maintain the semantic consistency of the record.

---

### ✅ **What Records Can Do**

* Can be **instantiated using `new`**.
* Can be **top-level or nested**; nested records are implicitly **static**.
* Can be **generic**.
* Can **implement interfaces**, including domain-specific or domain-independent ones (e.g., `Comparable`).
* Can have:

    * **Static methods**, fields, and initializers.
    * **Instance methods** (but not fields).
    * **Nested types**, including other records.

---

### 🔧 **Annotations and Serialization**

* **Annotations** on components are propagated to generated members.
* **Serialization is supported**, but:

    * **Custom serialization methods** (`writeObject`, `readObject`, etc.) are **not allowed**.
    * **Canonical constructor** governs deserialization.

---

### ⚠️ Core Principle

Record classes are designed for **data-carrier purposes**, emphasizing:

* **Immutability**
* **Transparent, well-defined state**
* **Simple, boilerplate-free syntax**

---
