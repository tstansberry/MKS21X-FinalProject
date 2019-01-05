# WordlistApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**wordlistSourceLangFiltersAdvancedGet**](WordlistApi.md#wordlistSourceLangFiltersAdvancedGet) | **GET** /wordlist/{source_lang}/{filters_advanced} | Retrieve list of words for category with advanced options
[**wordlistSourceLangFiltersBasicGet**](WordlistApi.md#wordlistSourceLangFiltersBasicGet) | **GET** /wordlist/{source_lang}/{filters_basic} | Retrieve a list of words in a category


<a name="wordlistSourceLangFiltersAdvancedGet"></a>
# **wordlistSourceLangFiltersAdvancedGet**
> Wordlist wordlistSourceLangFiltersAdvancedGet(sourceLang, filtersAdvanced, appId, appKey, exclude, excludeSenses, excludePrimeSenses, wordLength, prefix, exact, limit, offset)

Retrieve list of words for category with advanced options

Use this to apply more complex filters to the [list of words](documentation/glossary?term&#x3D;wordlist). For example, you may only want to filter out words for which all [senses](documentation/glossary?term&#x3D;sense) match the filter, or only its &#39;prime sense&#39;. You can also filter by word length or match by substring (prefix).     &lt;div id&#x3D;\&quot;wordlist_advanced\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WordlistApi;


WordlistApi apiInstance = new WordlistApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String filtersAdvanced = "filtersAdvanced_example"; // String | Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory=noun,adjective;domains=sport. Number of values limited to 5.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String exclude = "exclude_example"; // String | Semicolon separated list of parameters-value pairs (same as filters). Excludes headwords that have any senses in specified exclusion attributes (lexical categories, domains, etc.) from results.
String excludeSenses = "excludeSenses_example"; // String | Semicolon separated list of parameters-value pairs (same as filters). Excludes only those senses of a particular headword that match specified exclusion attributes (lexical categories, domains, etc.) from results but includes the headword if it has other permitted senses.
String excludePrimeSenses = "excludePrimeSenses_example"; // String | Semicolon separated list of parameters-value pairs (same as filters). Excludes a headword only if the primary sense matches the specified exclusion attributes (registers, domains only).
String wordLength = ">5,<10"; // String | Parameter to speficy the minimum (>), exact or maximum (<) length of the words required. E.g., >5 - more than 5 chars; <4 - less than 4 chars; >5<10 - from 5 to 10 chars; 3 - exactly 3 chars.
String prefix = "goal"; // String | Filter words that start with prefix parameter
Boolean exact = false; // Boolean | If exact=true wordlist returns a list of entries that exactly matches the search string. Otherwise wordlist lists entries that start with prefix string.
String limit = "limit_example"; // String | Limit the number of results per response. Default and maximum limit is 5000.
String offset = "offset_example"; // String | Offset the start number of the result.
try {
    Wordlist result = apiInstance.wordlistSourceLangFiltersAdvancedGet(sourceLang, filtersAdvanced, appId, appKey, exclude, excludeSenses, excludePrimeSenses, wordLength, prefix, exact, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WordlistApi#wordlistSourceLangFiltersAdvancedGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, hi, lv, sw, ta, gu]
 **filtersAdvanced** | **String**| Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory&#x3D;noun,adjective;domains&#x3D;sport. Number of values limited to 5. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **exclude** | **String**| Semicolon separated list of parameters-value pairs (same as filters). Excludes headwords that have any senses in specified exclusion attributes (lexical categories, domains, etc.) from results. | [optional]
 **excludeSenses** | **String**| Semicolon separated list of parameters-value pairs (same as filters). Excludes only those senses of a particular headword that match specified exclusion attributes (lexical categories, domains, etc.) from results but includes the headword if it has other permitted senses. | [optional]
 **excludePrimeSenses** | **String**| Semicolon separated list of parameters-value pairs (same as filters). Excludes a headword only if the primary sense matches the specified exclusion attributes (registers, domains only). | [optional]
 **wordLength** | **String**| Parameter to speficy the minimum (&gt;), exact or maximum (&lt;) length of the words required. E.g., &gt;5 - more than 5 chars; &lt;4 - less than 4 chars; &gt;5&lt;10 - from 5 to 10 chars; 3 - exactly 3 chars. | [optional] [default to &gt;5,&lt;10]
 **prefix** | **String**| Filter words that start with prefix parameter | [optional] [default to goal]
 **exact** | **Boolean**| If exact&#x3D;true wordlist returns a list of entries that exactly matches the search string. Otherwise wordlist lists entries that start with prefix string. | [optional] [default to false]
 **limit** | **String**| Limit the number of results per response. Default and maximum limit is 5000. | [optional]
 **offset** | **String**| Offset the start number of the result. | [optional]

### Return type

[**Wordlist**](Wordlist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="wordlistSourceLangFiltersBasicGet"></a>
# **wordlistSourceLangFiltersBasicGet**
> Wordlist wordlistSourceLangFiltersBasicGet(sourceLang, filtersBasic, appId, appKey, limit, offset)

Retrieve a list of words in a category

 Use this to retrieve a [list of words](documentation/glossary?term&#x3D;wordlist) for particular [domain](documentation/glossary?term&#x3D;domain), [lexical category](documentation/glossary?term&#x3D;lexicalcategory), [register](documentation/glossary?term&#x3D;registers) and/or [region](documentation/glossary?term&#x3D;regions). View the full list of possible filters using the filters Utility endpoint.  The response only includes [headwords](documentation/glossary?term&#x3D;headword), not all their possible [inflections](documentation/glossary?term&#x3D;inflection). If you require a full [wordlist](documentation/glossary?term&#x3D;wordlist) including [inflected forms](documentation/glossary?term&#x3D;inflection), contact us and we can help.    &lt;div id&#x3D;\&quot;wordlist\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WordlistApi;


WordlistApi apiInstance = new WordlistApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String filtersBasic = "filtersBasic_example"; // String | Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory=noun,adjective;domains=sport. Number of values limited to 5.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String limit = "limit_example"; // String | Limit the number of results per response. Default and maximum limit is 5000.
String offset = "offset_example"; // String | Offset the start number of the result
try {
    Wordlist result = apiInstance.wordlistSourceLangFiltersBasicGet(sourceLang, filtersBasic, appId, appKey, limit, offset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WordlistApi#wordlistSourceLangFiltersBasicGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, hi, lv, sw, ta, gu]
 **filtersBasic** | **String**| Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory&#x3D;noun,adjective;domains&#x3D;sport. Number of values limited to 5. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **limit** | **String**| Limit the number of results per response. Default and maximum limit is 5000. | [optional]
 **offset** | **String**| Offset the start number of the result | [optional]

### Return type

[**Wordlist**](Wordlist.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

