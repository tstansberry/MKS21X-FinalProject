# ThesaurusApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entriesSourceLangWordIdAntonymsGet**](ThesaurusApi.md#entriesSourceLangWordIdAntonymsGet) | **GET** /entries/{source_lang}/{word_id}/antonyms | Retrieve words that mean the opposite
[**entriesSourceLangWordIdSynonymsGet**](ThesaurusApi.md#entriesSourceLangWordIdSynonymsGet) | **GET** /entries/{source_lang}/{word_id}/synonyms | Retrieve words that are similar
[**entriesSourceLangWordIdSynonymsantonymsGet**](ThesaurusApi.md#entriesSourceLangWordIdSynonymsantonymsGet) | **GET** /entries/{source_lang}/{word_id}/synonyms;antonyms | Retrieve synonyms and antonyms for a given word


<a name="entriesSourceLangWordIdAntonymsGet"></a>
# **entriesSourceLangWordIdAntonymsGet**
> Thesaurus entriesSourceLangWordIdAntonymsGet(sourceLang, wordId, appId, appKey)

Retrieve words that mean the opposite

 Retrieve words that are opposite in meaning to the input word ([antonym](documentation/glossary?term&#x3D;thesaurus)).    &lt;div id&#x3D;\&quot;antonyms\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ThesaurusApi;


ThesaurusApi apiInstance = new ThesaurusApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Thesaurus result = apiInstance.entriesSourceLangWordIdAntonymsGet(sourceLang, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ThesaurusApi#entriesSourceLangWordIdAntonymsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Thesaurus**](Thesaurus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entriesSourceLangWordIdSynonymsGet"></a>
# **entriesSourceLangWordIdSynonymsGet**
> Thesaurus entriesSourceLangWordIdSynonymsGet(sourceLang, wordId, appId, appKey)

Retrieve words that are similar

 Use this to retrieve words that are similar in meaning to the input word ([synonym](documentation/glossary?term&#x3D;synonym)).    &lt;div id&#x3D;\&quot;synonyms\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ThesaurusApi;


ThesaurusApi apiInstance = new ThesaurusApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Thesaurus result = apiInstance.entriesSourceLangWordIdSynonymsGet(sourceLang, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ThesaurusApi#entriesSourceLangWordIdSynonymsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Thesaurus**](Thesaurus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="entriesSourceLangWordIdSynonymsantonymsGet"></a>
# **entriesSourceLangWordIdSynonymsantonymsGet**
> Thesaurus entriesSourceLangWordIdSynonymsantonymsGet(sourceLang, wordId, appId, appKey)

Retrieve synonyms and antonyms for a given word

 Retrieve available [synonyms](documentation/glossary?term&#x3D;thesaurus) and [antonyms](documentation/glossary?term&#x3D;thesaurus) for a given word and language.     &lt;div id&#x3D;\&quot;synonyms_and_antonyms\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ThesaurusApi;


ThesaurusApi apiInstance = new ThesaurusApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    Thesaurus result = apiInstance.entriesSourceLangWordIdSynonymsantonymsGet(sourceLang, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ThesaurusApi#entriesSourceLangWordIdSynonymsantonymsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code | [enum: en]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**Thesaurus**](Thesaurus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

