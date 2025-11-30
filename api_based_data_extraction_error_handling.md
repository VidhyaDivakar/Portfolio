# How to handle REST API Errors (400, 401, 494, 500)

## 1. Handle 400 - Invalid Schema or Bad Request

Cause for the 400 error - Wrong JSON structure, missing fields, invalid schema, or incorrect parameters.

**How to handle:**

* Validate your JSON with a schema validator before sending.
* Log the request body for debugging.
* Show a user-friendly message: “Please verify input format.”
* Retry **only after fixing** the request.
* Implement client-side validation (e.g., required fields, correct types).

```
JSON 
{
  "status": 400,
  "error": "Bad Request",
  "message": "Invalid input format. Fix the request payload.",
  "details": "Check schema for correct data structure and types."
}
```

---

## 2. Handle 401 - Missing/ Invalid API Key

**Cause for the 401 error:** API key not provided, expired, wrong token, or wrong header format.

**How to handle:**

* Ensure header has: `Authorization: Bearer YOUR_KEY`
* Store the API key securely (env variables, Vault).
* Refresh the key if expired.
* Never retry automatically—must fix credentials.

```
JAVA
If response.status == 401:
    refresh_key_if_possible()
    raise AuthenticationError("Invalid or missing API Key.") 
```

_____________________________________________________________________________________________________________________

## 3. Handle 404 – Agent or Job Not Found

**Cause for this 404 error** :Invalid agent_id, job_id, or wrong URL path.

**How to handle:**

* Double-check the agent or job ID.
* Log missing resource ID for debugging.
* Do not retry automatically (unless checking job status in a polling loop).
* Recreate the extraction agent if needed.

```
----JSON
{
  "condition": {
    "type": "http_status",
    "value": 404,
    "target": "response.status"
  },
  "actions": [
    {
      "type": "log",
      "message": "Requested agent or job not found. ID may be wrong."
    },
    {
      "type": "notify_user",
      "message": "Resource not found. Please verify IDs."
    }
  ]
}
```

---

## **4. Handle 500 – Internal Extraction Error**

**Cause for the 500 error:** Server error, model failure, extraction timeout, or backend issue.

**How to handle:**

* Implement exponential backoff retry (e.g., try again after 3s, 9s).
* Capture logs and error messages for investigation.
* Notify user: “Extraction service temporarily unavailable.”
* If recurring, send the file again or simplify the schema.

```
JSON
{
  "response": {
    "status": 500,
    "action": "retry_with_backoff",
    "parameters": {
      "max_attempts": 3
    },
    "user_notification": "Server error. Please try again later."
  }
}
```

```

```
