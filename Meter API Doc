## API Documentation for Meter API

### High-Level Purpose of this API Documentation

In this API documentation, you can find details about the Integration notes, API calls, Query Parameters, API Response samples, and endpoints. The purpose of this document is to help readers understand the nuances of the API and its technical specifications, and handle API Requests and API responses effectively.

### What is the purpose of this API?

The Utility API is used to collect the energy (Gas, Water, Electricity) consumption data of the households based on the Zone and County specific in a specified period of time. The types of houses considered are Multifamily, Single Family, and Ranch. This API helps to collect individual consumption data and bulk data. The idea behind this API is to help the technician/data analysts access the data to carry out their daily activities, that is, household energy consumption that needs inspections or meter change, or any other discrepancies, so that the property can be inspected by visiting the same.

### How to access this API?

All the API requests can be made using the BASE URL <https://energyusage.com/api/v1>. Each API has its own authentication process. To access the API, you need to request an API key from the Utility Company API portal. You need to add your API Key along with your requests. There are two ways using which you can pass the API key to the API.

Option A: Pass API key in the HTTP header (recommended)

```GET /meters?county=A&zone=ABC&status=inactive HTTP/1.1 Host: energyusage.com x-api-key: YOUR_API_KEY```

Option B: Pass API key as a query parameter (not recommended for production)

```https://energyusage.com/api/v1/meters?county=A&zone=ABC&status=inactive&apikey=YOUR_API_KEY```

This Utility API helps to collect data of the Households in three counties, A, B, and C, in the Residential Zones. Here, the list of information that can be retrieved in the context of these households:

- Individual Household consumption tracking - Water, Gas, Electricity meter data

- Cumulative Consumption

- Household count and types

- Filtering households by county and their type

Based on the data given above, we are going to work on one or two endpoints and decipher and see how we can call (make a request call) the API for data, and how to see a few sample responses.

### Meter Endpoint

Meter endpoint gives gas, water, and electricity consumption of one or more households for a specified period of time, or by default, the current meter reading. Each meter is linked to an address, and based on that, we use the API calls to manage the households’ meters.  The data collected using this endpoint can be used by a meter reader/field technician to do some inspections

### Endpoints

Endpoints       |         | Description                           |
|----------------|-------------|---------------------------------------|
|GET /county/{countyname}/meter/{meterid}   |      | Get all the meter details in the county. |
| GET /meters/{meter_type}  |   | To get all the meters of a type – Gas, Electricity, Water.      |
| GET /route  |      | To find the route of the meters based on their statuses. This can be achieved using the addresses pinned to the meters.
| GET /meters/{meter_type}/count/{countno}  |      | Get the total number of meters based on the type.
| PUT /meter/{meter_id} |      | Get consumption details of a single meter.
| PATCH /meter/{meter_id}  |      | Update the meter readings    |

## Explaining a single Endpoint

Endpoint URL Example           |         | <https://energyusage.com/api/v1/county/A/meter/A10001>                            |
|----------------   |-------------   |---------------------------------------|
|Endpoint Example  |      | GET /county/{county}/meter/{meterid} |
| Data Coverage |   | County A      |
| Time Captured |      | Less than one hour
| Reading Capture time interval  |      | One hour

## Parameters

Path Parameters        |      | Description                           |
|----------------|-------------|---------------------------------------|
| {county}   |      | The name of the county where the meters are located. |
| {meterid} |    | The meter ID of a single meter. The meter ID can be accessed from the energyusage.com website      |

## Query String Parameters

| Query String Parameter | Required/Optional | Data Type | Description |
|:------------------------|:------------------|:-----------|:-------------|
| `{meter_type}` | Optional | Alphanumeric | The type of the meter, that is, electricity, gas, or water. You can enter the type name to get the energy consumption details that the meter measured. |
| `{Zone}` | Optional | Alphanumeric | The Zone in which the meter is placed. |
| `{reading}` | Optional | Integer | The meter reading that is displayed on the meter. |
| `{date range}` | Optional | Integer | The period during which the consumption is done. |
| `{Status}` | Optional | String | The status of the meter is as follows:<br>**Active** – Meter is installed, working, and reports energy consumption normally.<br>**Inactive** – Meter is installed, but not in use (e.g., vacant, disconnected).<br>**Faulty** – Meter is malfunctioning or not sending correct readings.<br>**Maintenance** – Meter temporarily out of service for inspection or repair.<br>**Retired** – Meter permanently removed or replaced.<br>**Pending Activation** – Newly installed meter awaiting activation.<br>**Calibration** – Meter under test or adjustment for accuracy. |

## Sample Request

This request gives an example workflow for a technician who wants to inspect water meters that are not functioning properly. This request also helps to retrieve the data and create a route of inactive water meters from the above API.

Enter the following URL in a curl, Postman, or whichever application you find suitable.

```https://energyusage.com/api/v1/meters?county=A&zone=ABC&metertype=water&status=inactive```

## Sample Response

The following is the API response sent for the above API Request.

```json
[
  {
    "meter_id": "M20001",
    "meter_type": "water",
    "status": "inactive",
    "household_id": "4573",
    "location": {
      "county": "A",
      "zone": "ABC",
      "address": "4573 Elm Street",
      "latitude": 34.12345,
      "longitude": -84.12345
    }
  },
  {
    "meter_id": "M20002",
    "meter_type": "water",
    "status": "inactive",
    "household_id": "5878",
    "location": {
      "county": "A",
      "zone": "South Ridge",
      "address": "5878 Pine Avenue",
      "latitude": 34.54321,
      "longitude": -84.54321
    }
  }
]
```

## Response description

| Field         | Data Type    | Description                                                                                  | Example / Notes                       |
|---------------|-------------|----------------------------------------------------------------------------------------------|---------------------------------------|
| meterid       | Alphanumeric| The meter ID of a single meter, for which the Technician needs to inspect.                  | MTR12345                              |
| Meter_type    | String      | The type of the meter, that is, Gas, Electric, or Water, present in the household.         | Gas, Electric, Water                  |
| status        | String      | The status of the meter. See {status} for more info.                                         | Active, Inactive                      |
| Last_reading  | Integer     | Timestamp of the last reading of the meter in ISO 8601 format.                               | 2025-09-20T10:30:00Z 2025-09-20 – Represents the date September 20, 2025. T is the separator between the time and the date and marks the beginning of the date. 10:30:00 – Represents the time. Z signifies that the time is in Coordinated Universal Time (UTC), also known as "Zulu time," with a zero offset from UTC.                  |
| Household_ID  | Integer     | The household number where the meters are installed .                                         | 101                                    |
| Location      | String      | The location data includes the county, zone, and the physical address of the household.     | 123 Main St, Zone 5, Fulton County   |
| County        | String      | The county where the utility company’s technician is sent for inspection.                    | Fulton                                 |
| Zone          | String      | The Zone where the utility company’s technician is sent for inspection.                      | Zone 5                                 |
| Address       | String      | The physical address of the household where the meter is located.                            | 123 Main St                            |
| Latitude      | Integer     | The latitudinal coordinates of the household to determine the inspection route.             | 33                                     |
| Longitude     | Integer     | The longitudinal coordinates of the household to determine the inspection route.            | -84                                    |

## Request 2

Request to get a list of households that needs new water meters installed in County B.

```
https://energyusage.com/api/v1/households?county=B&meter_type=water&status=needs_replacement

Example Request 

curl -X GET "https://energyusage.com/api/v1/households?county=B&meter_type=water&status=needs_replacement"
```

The following is the API response sent for the above API Request.

## Response

```json
{
  "request": {
    "county": "B",
    "meter_type": "water",
    "status": "needs replacement"
  },
  "results": [
    {
      "household_id": "4573",
      "household_type": "Single Family",
      "address": "4573 Oak Avenue",
      "zone": "Z1",
      "meter": {
        "meter_id": "W5678",
        "meter_type": "water",
        "status": "needs_replacement",
        "last_inspection": "2025-08-20"
      }
    },
    {
      "household_id": "7684",
      "household_type": "Multifamily",
      "address": "7684 Maple Drive",
      "zone": "Z3",
      "meter": {
        "meter_id": "W5680",
        "meter_type": "water",
        "status": "needs_replacement",
        "last_inspection": "2025-09-05"
      }
    }
  ],
  "count": 2
}
```

## Response

| Field            | Data Type    | Description                                                                                  |
|-----------------|-------------|----------------------------------------------------------------------------------------------|
| householdid      | Integer     | The household’s street number                                                                |
| Household_type   | String      | The household’s type namely, Single Family, Multifamily, Townhome, Condo, Apartment.        |
| Address          | String      | The physical address of the household where the meter is located.                            |
| Zone             | String      | The Zone where the utility company’s technician is sent for inspection.                      |
| meter            | Alphanumeric| This section gives the information about the meter in the following lines.                   |
| meterid          | Alphanumeric| The meter ID of a single meter, for which the Technician needs to inspect.                  |
| Meter_type       | String      | The type of the meter, that is, Gas, Electric, or Water, present in the household.          |
| status           | String      | The status of the meter. See {status} for more info.                                         |
| Last_reading     | Integer     | Timestamp of the last reading of the meter in ISO 8601 format. 2025-09-20 – Represents the date September 20, 2025. T is the separator between the time and the date and marks the beginning of the date.10:30:00 – Represents the time. Z signifies that the time is in Coordinated Universal Time (UTC), also known as "Zulu time," with a zero offset from UTC..                               |
| Household_ID     | Integer     | The household number where the meters are installed.                                         |
| Location         | String      | The location data includes the county, zone, and the physical address of the household.     |
| County           | String      | The county where the utility company’s technician is sent for inspection.                    |
| Last_inspection  | Numeric     | The date on which the last inspection occurred (YYYY-MM-DD format).                          |

### In a nutshell

The API has many endpoints with data in key and value pairs, and to retrieve data from the API, you use the apt Request URL with query parameters.  Please refer the Endpoint and Query Parameter sections to get details to create a API Request.
