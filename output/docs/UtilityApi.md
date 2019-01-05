# UtilityApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**domainsSourceDomainsLanguageTargetDomainsLanguageGet**](UtilityApi.md#domainsSourceDomainsLanguageTargetDomainsLanguageGet) | **GET** /domains/{source_domains_language}/{target_domains_language} | Lists available domains in a bilingual dataset
[**domainsSourceLanguageGet**](UtilityApi.md#domainsSourceLanguageGet) | **GET** /domains/{source_language} | Lists available domains in a monolingual dataset
[**filtersEndpointGet**](UtilityApi.md#filtersEndpointGet) | **GET** /filters/{endpoint} | Lists available filters for specific endpoint
[**filtersGet**](UtilityApi.md#filtersGet) | **GET** /filters | Lists available filters
[**grammaticalFeaturesSourceLanguageGet**](UtilityApi.md#grammaticalFeaturesSourceLanguageGet) | **GET** /grammaticalFeatures/{source_language} | Lists available grammatical features in a dataset
[**languagesGet**](UtilityApi.md#languagesGet) | **GET** /languages | Lists available dictionaries
[**lexicalcategoriesLanguageGet**](UtilityApi.md#lexicalcategoriesLanguageGet) | **GET** /lexicalcategories/{language} | Lists available lexical categories in a dataset
[**regionsSourceLanguageGet**](UtilityApi.md#regionsSourceLanguageGet) | **GET** /regions/{source_language} | Lists available regions in a monolingual dataset
[**registersSourceLanguageGet**](UtilityApi.md#registersSourceLanguageGet) | **GET** /registers/{source_language} | Lists available registers in a  monolingual dataset
[**registersSourceRegisterLanguageTargetRegisterLanguageGet**](UtilityApi.md#registersSourceRegisterLanguageTargetRegisterLanguageGet) | **GET** /registers/{source_register_language}/{target_register_language} | Lists available registers in a bilingual dataset


<a name="domainsSourceDomainsLanguageTargetDomainsLanguageGet"></a>
# **domainsSourceDomainsLanguageTargetDomainsLanguageGet**
> UtilityLabels domainsSourceDomainsLanguageTargetDomainsLanguageGet(sourceDomainsLanguage, targetDomainsLanguage, appId, appKey)

Lists available domains in a bilingual dataset

Returns a list of the available [domains](documentation/glossary?term&#x3D;domain) for a given bilingual language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceDomainsLanguage = "sourceDomainsLanguage_example"; // String | IANA language code
String targetDomainsLanguage = "targetDomainsLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.domainsSourceDomainsLanguageTargetDomainsLanguageGet(sourceDomainsLanguage, targetDomainsLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#domainsSourceDomainsLanguageTargetDomainsLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceDomainsLanguage** | **String**| IANA language code | [enum: en, es, nso, zu, ur, de, pt]
 **targetDomainsLanguage** | **String**| IANA language code | [enum: es, nso, zu, ms, id, tn, ro, de, pt]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="domainsSourceLanguageGet"></a>
# **domainsSourceLanguageGet**
> UtilityLabels domainsSourceLanguageGet(sourceLanguage, appId, appKey)

Lists available domains in a monolingual dataset

Returns a list of the available [domains](documentation/glossary?term&#x3D;domain) for a given monolingual language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.domainsSourceLanguageGet(sourceLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#domainsSourceLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLanguage** | **String**| IANA language code | [enum: en, es, nso, zu, hi, sw, ur, de, pt, ta, gu]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="filtersEndpointGet"></a>
# **filtersEndpointGet**
> Filters filtersEndpointGet(endpoint, appId, appKey)

Lists available filters for specific endpoint

Returns a list of all the valid filters for a given endpoint to construct API calls. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String endpoint = "endpoint_example"; // String | Name of the endpoint.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Filters result = apiInstance.filtersEndpointGet(endpoint, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#filtersEndpointGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endpoint** | **String**| Name of the endpoint. | [enum: entries, inflections, translations]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Filters**](Filters.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="filtersGet"></a>
# **filtersGet**
> Filters filtersGet(appId, appKey)

Lists available filters

Returns a list of all the valid filters to construct API calls. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Filters result = apiInstance.filtersGet(appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#filtersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Filters**](Filters.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="grammaticalFeaturesSourceLanguageGet"></a>
# **grammaticalFeaturesSourceLanguageGet**
> UtilityLabels grammaticalFeaturesSourceLanguageGet(sourceLanguage, appId, appKey)

Lists available grammatical features in a dataset

Returns a list of the available [grammatical features](documentation/glossary?term&#x3D;grammaticalfeatures) for a given language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code. If provided output will be filtered by sourceLanguage.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.grammaticalFeaturesSourceLanguageGet(sourceLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#grammaticalFeaturesSourceLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLanguage** | **String**| IANA language code. If provided output will be filtered by sourceLanguage. | [enum: en, es, lv, nso, zu, ms, tn, ur, hi, sw, de, pt, ta, gu]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="languagesGet"></a>
# **languagesGet**
> Languages languagesGet(appId, appKey, sourceLanguage, targetLanguage)

Lists available dictionaries

Returns a list of monolingual and bilingual language datasets available in the API 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code. If provided output will be filtered by sourceLanguage.
String targetLanguage = "targetLanguage_example"; // String | IANA language code. If provided output will be filtered by sourceLanguage.
try {
    Languages result = apiInstance.languagesGet(appId, appKey, sourceLanguage, targetLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#languagesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **sourceLanguage** | **String**| IANA language code. If provided output will be filtered by sourceLanguage. | [optional] [enum: es, en, lv, nso, zu, ms, id, tn, ur, hi, sw, ro, de, pt, ta, gu]
 **targetLanguage** | **String**| IANA language code. If provided output will be filtered by sourceLanguage. | [optional] [enum: es, en, lv, nso, zu, ms, id, tn, ur, hi, sw, ro]

### Return type

[**Languages**](Languages.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="lexicalcategoriesLanguageGet"></a>
# **lexicalcategoriesLanguageGet**
> UtilityLabels lexicalcategoriesLanguageGet(language, appId, appKey)

Lists available lexical categories in a dataset

Returns a list of available [lexical categories](documentation/glossary?term&#x3D;lexicalcategory) for a given language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String language = "language_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.lexicalcategoriesLanguageGet(language, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#lexicalcategoriesLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **language** | **String**| IANA language code | [enum: es, en, lv, nso, zu, ms, id, tn, ur, hi, sw, ro, de, pt, ta, gu]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="regionsSourceLanguageGet"></a>
# **regionsSourceLanguageGet**
> Regions regionsSourceLanguageGet(sourceLanguage, appId, appKey)

Lists available regions in a monolingual dataset

Returns a list of the available [regions](documentation/glossary?term&#x3D;regions) for a given monolingual language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Regions result = apiInstance.regionsSourceLanguageGet(sourceLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#regionsSourceLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLanguage** | **String**| IANA language code | [enum: en]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Regions**](Regions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registersSourceLanguageGet"></a>
# **registersSourceLanguageGet**
> UtilityLabels registersSourceLanguageGet(sourceLanguage, appId, appKey)

Lists available registers in a  monolingual dataset

Returns a list of the available [registers](documentation/glossary?term&#x3D;registers) for a given monolingual language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.registersSourceLanguageGet(sourceLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#registersSourceLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLanguage** | **String**| IANA language code | [enum: en, es, hi, id, lv, ms, sw, ur, de, pt, ta, gu]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registersSourceRegisterLanguageTargetRegisterLanguageGet"></a>
# **registersSourceRegisterLanguageTargetRegisterLanguageGet**
> UtilityLabels registersSourceRegisterLanguageTargetRegisterLanguageGet(sourceRegisterLanguage, targetRegisterLanguage, appId, appKey)

Lists available registers in a bilingual dataset

Returns a list of the available [registers](documentation/glossary?term&#x3D;registers) for a given bilingual language dataset. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UtilityApi;


UtilityApi apiInstance = new UtilityApi();
String sourceRegisterLanguage = "sourceRegisterLanguage_example"; // String | IANA language code
String targetRegisterLanguage = "targetRegisterLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    UtilityLabels result = apiInstance.registersSourceRegisterLanguageTargetRegisterLanguageGet(sourceRegisterLanguage, targetRegisterLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UtilityApi#registersSourceRegisterLanguageTargetRegisterLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceRegisterLanguage** | **String**| IANA language code | [enum: en, es, ms, id, ur, de, pt]
 **targetRegisterLanguage** | **String**| IANA language code | [enum: es, en, nso, zu, ms, id, tn, ro, de, pt]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**UtilityLabels**](UtilityLabels.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

