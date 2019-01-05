# SearchApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchSourceLangGet**](SearchApi.md#searchSourceLangGet) | **GET** /search/{source_lang} | Retrieve possible matches to input
[**searchSourceSearchLanguageTranslationstargetSearchLanguageGet**](SearchApi.md#searchSourceSearchLanguageTranslationstargetSearchLanguageGet) | **GET** /search/{source_search_language}/translations&#x3D;{target_search_language} | Retrieve possible translation matches to input


<a name="searchSourceLangGet"></a>
# **searchSourceLangGet**
> Wordlist searchSourceLangGet(sourceLang, appId, appKey, q, prefix, regions, limit, offset)

Retrieve possible matches to input

 Use this to retrieve possible [headword](documentation/glossary?term&#x3D;headword) matches for a given string of text. The results are culculated using headword matching, fuzzy matching, and [lemmatization](documentation/glossary?term&#x3D;lemma)     &lt;div id&#x3D;\&quot;search\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String q = "eye"; // String | Search string
Boolean prefix = false; // Boolean | Set prefix to true if you'd like to get results only starting with search string.
String regions = "regions_example"; // String | If searching in English, filter words with specific region(s) either 'us' or 'gb'.
String limit = "limit_example"; // String | Limit the number of results per response. Default and maximum limit is 5000.
String offset = "offset_example"; // String | Offset the start number of the result.
try {
    Wordlist result = apiInstance.searchSourceLangGet(sourceLang, appId, appKey, q, prefix, regions, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchSourceLangGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, hi, lv, sw, ta, gu]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **q** | **String**| Search string | [optional] [default to eye]
 **prefix** | **Boolean**| Set prefix to true if you&#39;d like to get results only starting with search string. | [optional] [default to false]
 **regions** | **String**| If searching in English, filter words with specific region(s) either &#39;us&#39; or &#39;gb&#39;. | [optional]
 **limit** | **String**| Limit the number of results per response. Default and maximum limit is 5000. | [optional]
 **offset** | **String**| Offset the start number of the result. | [optional]

### Return type

[**Wordlist**](Wordlist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchSourceSearchLanguageTranslationstargetSearchLanguageGet"></a>
# **searchSourceSearchLanguageTranslationstargetSearchLanguageGet**
> Wordlist searchSourceSearchLanguageTranslationstargetSearchLanguageGet(sourceSearchLanguage, targetSearchLanguage, appId, appKey, q, prefix, regions, limit, offset)

Retrieve possible translation matches to input

 Use this to find matches in our translation dictionaries.    &lt;div id&#x3D;\&quot;search_translation\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
String sourceSearchLanguage = "sourceSearchLanguage_example"; // String | IANA language code
String targetSearchLanguage = "targetSearchLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String q = "eye"; // String | Search string.
Boolean prefix = false; // Boolean | Set prefix to true if you'd like to get results only starting with search string.
String regions = "regions_example"; // String | Filter words with specific region(s) E.g., regions=us. For now gb, us are available for en language.
String limit = "limit_example"; // String | Limit the number of results per response. Default and maximum limit is 5000.
String offset = "offset_example"; // String | Offset the start number of the result.
try {
    Wordlist result = apiInstance.searchSourceSearchLanguageTranslationstargetSearchLanguageGet(sourceSearchLanguage, targetSearchLanguage, appId, appKey, q, prefix, regions, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchSourceSearchLanguageTranslationstargetSearchLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceSearchLanguage** | **String**| IANA language code | [enum: en, es, nso, zu, ms, id, tn, ur, de, pt]
 **targetSearchLanguage** | **String**| IANA language code | [enum: es, nso, zu, ms, id, tn, ro, de, pt]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **q** | **String**| Search string. | [optional] [default to eye]
 **prefix** | **Boolean**| Set prefix to true if you&#39;d like to get results only starting with search string. | [optional] [default to false]
 **regions** | **String**| Filter words with specific region(s) E.g., regions&#x3D;us. For now gb, us are available for en language. | [optional]
 **limit** | **String**| Limit the number of results per response. Default and maximum limit is 5000. | [optional]
 **offset** | **String**| Offset the start number of the result. | [optional]

### Return type

[**Wordlist**](Wordlist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

