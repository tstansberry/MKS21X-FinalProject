# DictionaryEntriesApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entriesSourceLangWordIdFiltersGet**](DictionaryEntriesApi.md#entriesSourceLangWordIdFiltersGet) | **GET** /entries/{source_lang}/{word_id}/{filters} | Apply filters to response
[**entriesSourceLangWordIdGet**](DictionaryEntriesApi.md#entriesSourceLangWordIdGet) | **GET** /entries/{source_lang}/{word_id} | Retrieve dictionary information for a given word
[**entriesSourceLangWordIdRegionsregionGet**](DictionaryEntriesApi.md#entriesSourceLangWordIdRegionsregionGet) | **GET** /entries/{source_lang}/{word_id}/regions&#x3D;{region} | Specify GB or US dictionary for English entry search


<a name="entriesSourceLangWordIdFiltersGet"></a>
# **entriesSourceLangWordIdFiltersGet**
> RetrieveEntry entriesSourceLangWordIdFiltersGet(sourceLang, wordId, filters, appId, appKey)

Apply filters to response

 Use filters to limit the [entry](documentation/glossary?term&#x3D;entry) information that is returned. For example, you may only require definitions and not everything else, or just [pronunciations](documentation/glossary?term&#x3D;pronunciation). The full list of filters can be retrieved from the filters Utility endpoint. You can also specify values within the filter using &#39;&#x3D;&#39;. For example &#39;grammaticalFeatures&#x3D;singular&#39;. Filters can also be combined using a semicolon.    &lt;div id&#x3D;\&quot;dictionary_entries_filters\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DictionaryEntriesApi;


DictionaryEntriesApi apiInstance = new DictionaryEntriesApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
List<String> filters = Arrays.asList("filters_example"); // List<String> | Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    RetrieveEntry result = apiInstance.entriesSourceLangWordIdFiltersGet(sourceLang, wordId, filters, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DictionaryEntriesApi#entriesSourceLangWordIdFiltersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, lv, hi, sw, ta, gu]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **filters** | [**List&lt;String&gt;**](String.md)| Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**RetrieveEntry**](RetrieveEntry.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entriesSourceLangWordIdGet"></a>
# **entriesSourceLangWordIdGet**
> RetrieveEntry entriesSourceLangWordIdGet(sourceLang, wordId, appId, appKey)

Retrieve dictionary information for a given word

 Use this to retrieve definitions, [pronunciations](documentation/glossary?term&#x3D;pronunciation), example sentences, [grammatical information](documentation/glossary?term&#x3D;grammaticalfeatures) and [word origins](documentation/glossary?term&#x3D;etymology). It only works for dictionary [headwords](documentation/glossary?term&#x3D;headword), so you may need to use the [Lemmatron](documentation/glossary?term&#x3D;lemma) first if your input is likely to be an [inflected](documentation/glossary?term&#x3D;inflection) form (e.g., &#39;swimming&#39;). This would return the linked [headword](documentation/glossary?term&#x3D;headword) (e.g., &#39;swim&#39;) which you can then use in the Entries endpoint. Unless specified using a region filter, the default lookup will be the Oxford Dictionary of English (GB).    &lt;div id&#x3D;\&quot;dictionary_entries\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DictionaryEntriesApi;


DictionaryEntriesApi apiInstance = new DictionaryEntriesApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    RetrieveEntry result = apiInstance.entriesSourceLangWordIdGet(sourceLang, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DictionaryEntriesApi#entriesSourceLangWordIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, lv, hi, sw, ta, gu]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**RetrieveEntry**](RetrieveEntry.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entriesSourceLangWordIdRegionsregionGet"></a>
# **entriesSourceLangWordIdRegionsregionGet**
> RetrieveEntry entriesSourceLangWordIdRegionsregionGet(sourceLang, wordId, region, appId, appKey)

Specify GB or US dictionary for English entry search

 USe this filter to restrict the lookup to either our Oxford Dictionary of English (GB) or New Oxford American Dictionary (US). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DictionaryEntriesApi;


DictionaryEntriesApi apiInstance = new DictionaryEntriesApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String region = "region_example"; // String | Region filter parameter. gb = Oxford Dictionary of English. us = New Oxford American Dictionary.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    RetrieveEntry result = apiInstance.entriesSourceLangWordIdRegionsregionGet(sourceLang, wordId, region, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DictionaryEntriesApi#entriesSourceLangWordIdRegionsregionGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **region** | **String**| Region filter parameter. gb &#x3D; Oxford Dictionary of English. us &#x3D; New Oxford American Dictionary. | [enum: gb, us]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**RetrieveEntry**](RetrieveEntry.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

