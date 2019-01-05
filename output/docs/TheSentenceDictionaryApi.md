# TheSentenceDictionaryApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entriesSourceLanguageWordIdSentencesGet**](TheSentenceDictionaryApi.md#entriesSourceLanguageWordIdSentencesGet) | **GET** /entries/{source_language}/{word_id}/sentences | Retrieve corpus sentences for a given word


<a name="entriesSourceLanguageWordIdSentencesGet"></a>
# **entriesSourceLanguageWordIdSentencesGet**
> SentencesResults entriesSourceLanguageWordIdSentencesGet(sourceLanguage, wordId, appId, appKey)

Retrieve corpus sentences for a given word

 Use this to retrieve sentences extracted from  corpora which show how a word is used in the language. This is available for English and Spanish. For English, the sentences are linked to the correct [sense](documentation/glossary?term&#x3D;sense) of the word in the dictionary. In Spanish, they are linked at the [headword](documentation/glossary?term&#x3D;headword) level.   &lt;div id&#x3D;\&quot;sentences\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TheSentenceDictionaryApi;


TheSentenceDictionaryApi apiInstance = new TheSentenceDictionaryApi();
String sourceLanguage = "sourceLanguage_example"; // String | IANA language code
String wordId = "wordId_example"; // String | An Entry identifier. Case-sensitive.
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    SentencesResults result = apiInstance.entriesSourceLanguageWordIdSentencesGet(sourceLanguage, wordId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TheSentenceDictionaryApi#entriesSourceLanguageWordIdSentencesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLanguage** | **String**| IANA language code | [enum: en, es]
 **wordId** | **String**| An Entry identifier. Case-sensitive. |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**SentencesResults**](SentencesResults.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

