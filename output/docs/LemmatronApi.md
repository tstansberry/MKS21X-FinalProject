# LemmatronApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**inflectionsSourceLangWordIdFiltersGet**](LemmatronApi.md#inflectionsSourceLangWordIdFiltersGet) | **GET** /inflections/{source_lang}/{word_id}/{filters} | Apply optional filters to Lemmatron response
[**inflectionsSourceLangWordIdGet**](LemmatronApi.md#inflectionsSourceLangWordIdGet) | **GET** /inflections/{source_lang}/{word_id} | Check a word exists in the dictionary and retrieve its root form


<a name="inflectionsSourceLangWordIdFiltersGet"></a>
# **inflectionsSourceLangWordIdFiltersGet**
> Lemmatron inflectionsSourceLangWordIdFiltersGet(sourceLang, wordId, filters, appId, appKey)

Apply optional filters to Lemmatron response

 Retrieve available [lemmas](documentation/glossary?term&#x3D;lemma) for a given [inflected](documentation/glossary?term&#x3D;inflection) wordform. Filter results by categories.      &lt;div id&#x3D;\&quot;lemmatron_filters\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LemmatronApi;


LemmatronApi apiInstance = new LemmatronApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | The input word
List<String> filters = Arrays.asList("filters_example"); // List<String> | Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Lemmatron result = apiInstance.inflectionsSourceLangWordIdFiltersGet(sourceLang, wordId, filters, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LemmatronApi#inflectionsSourceLangWordIdFiltersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, hi, nso, tn, zu, de, pt]
 **wordId** | **String**| The input word |
 **filters** | [**List&lt;String&gt;**](String.md)| Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Lemmatron**](Lemmatron.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="inflectionsSourceLangWordIdGet"></a>
# **inflectionsSourceLangWordIdGet**
> Lemmatron inflectionsSourceLangWordIdGet(sourceLang, wordId, appId, appKey)

Check a word exists in the dictionary and retrieve its root form

 Use this to check if a word exists in the dictionary, or what &#39;root&#39; form it links to (e.g., swimming &gt; swim). The response tells you the possible [lemmas](documentation/glossary?term&#x3D;lemma) for a given [inflected](documentation/glossary?term&#x3D;inflection) word. This can then be combined with other endpoints to retrieve more information.    &lt;div id&#x3D;\&quot;lemmatron\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LemmatronApi;


LemmatronApi apiInstance = new LemmatronApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | The input word
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Lemmatron result = apiInstance.inflectionsSourceLangWordIdGet(sourceLang, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LemmatronApi#inflectionsSourceLangWordIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en, es, hi, nso, tn, zu, de, pt]
 **wordId** | **String**| The input word |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Lemmatron**](Lemmatron.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

