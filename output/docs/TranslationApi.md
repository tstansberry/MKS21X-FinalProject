# TranslationApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet**](TranslationApi.md#entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet) | **GET** /entries/{source_translation_language}/{word_id}/translations&#x3D;{target_translation_language} | Retrieve translation for a given word


<a name="entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet"></a>
# **entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet**
> RetrieveEntry entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet(sourceTranslationLanguage, wordId, targetTranslationLanguage, appId, appKey)

Retrieve translation for a given word

 Use this to return translations for a given word. In the event that a word in the dataset does not have a direct translation, the response will be a [definition](documentation/glossary?term&#x3D;entry) in the target language.    &lt;div id&#x3D;\&quot;translation\&quot;&gt;&lt;/div&gt; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TranslationApi;


TranslationApi apiInstance = new TranslationApi();
String sourceTranslationLanguage = "sourceTranslationLanguage_example"; // String | IANA language code
String wordId = "wordId_example"; // String | The source word
String targetTranslationLanguage = "targetTranslationLanguage_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
try {
    RetrieveEntry result = apiInstance.entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet(sourceTranslationLanguage, wordId, targetTranslationLanguage, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TranslationApi#entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceTranslationLanguage** | **String**| IANA language code | [enum: en, es, nso, zu, ms, id, tn, ur, de, pt]
 **wordId** | **String**| The source word |
 **targetTranslationLanguage** | **String**| IANA language code | [enum: es, nso, zu, ms, id, tn, ro, de, pt]
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]

### Return type

[**RetrieveEntry**](RetrieveEntry.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

