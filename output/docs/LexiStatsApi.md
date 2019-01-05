# LexiStatsApi

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**statsFrequencyNgramsSourceLangCorpusNgramSizeGet**](LexiStatsApi.md#statsFrequencyNgramsSourceLangCorpusNgramSizeGet) | **GET** /stats/frequency/ngrams/{source_lang}/{corpus}/{ngram-size}/ | Retrieve the frequency of ngrams (1-4) derived from a corpus
[**statsFrequencyWordSourceLangGet**](LexiStatsApi.md#statsFrequencyWordSourceLangGet) | **GET** /stats/frequency/word/{source_lang}/ | Retrieve the frequency of a word derived from a corpus.
[**statsFrequencyWordsSourceLangGet**](LexiStatsApi.md#statsFrequencyWordsSourceLangGet) | **GET** /stats/frequency/words/{source_lang}/ | Retrieve a list of frequencies of a word/words derived from a corpus.


<a name="statsFrequencyNgramsSourceLangCorpusNgramSizeGet"></a>
# **statsFrequencyNgramsSourceLangCorpusNgramSizeGet**
> NgramsResult statsFrequencyNgramsSourceLangCorpusNgramSizeGet(sourceLang, corpus, ngramSize, appId, appKey, tokens, contains, punctuation, format, minFrequency, maxFrequency, minDocumentFrequency, maxDocumentFrequency, collate, sort, offset, limit)

Retrieve the frequency of ngrams (1-4) derived from a corpus

This endpoint returns frequencies of ngrams of size 1-4. That is the number of times a word (ngram size &#x3D; 1) or words (ngram size &gt; 1) appear in the corpus. Ngrams are case sensitive (\&quot;I AM\&quot; and \&quot;I am\&quot; will have different frequency) and frequencies are calculated per word (true case) so \&quot;the book\&quot; and \&quot;the books\&quot; are two different ngrams. The results can be filtered based on query parameters. &lt;br&gt; &lt;br&gt; Parameters can be provided in PATH, GET or POST (form or json). The parameters in PATH are overridden by parameters in GET, POST and json (in that order). In PATH, individual options are separated by semicolon and values are separated by commas (where multiple values can be used). &lt;br&gt; &lt;br&gt; Example for bigrams (ngram of size 2): * PATH: /tokens&#x3D;a word,another word * GET: /?tokens&#x3D;a word&amp;tokens&#x3D;another word * POST (json):    &#x60;&#x60;&#x60;javascript     {         \&quot;tokens\&quot;: [\&quot;a word\&quot;, \&quot;another word\&quot;]     }   &#x60;&#x60;&#x60;  Either \&quot;tokens\&quot; or \&quot;contains\&quot; has to be provided. &lt;br&gt; &lt;br&gt; Some queries with \&quot;contains\&quot; or \&quot;sort\&quot; can exceed the 30s timeout, in which case the API will return an error message with status code 503. You mitigate this by providing additional restrictions such as \&quot;minFrequency\&quot; and \&quot;maxFrequency\&quot;. &lt;br&gt; &lt;br&gt; You can use the parameters \&quot;offset\&quot; and \&quot;limit\&quot; to paginate through large result sets. For convenience, the HTTP header \&quot;Link\&quot; is set on the response to provide links to \&quot;first\&quot;, \&quot;self\&quot;, \&quot;next\&quot;, \&quot;prev\&quot; and \&quot;last\&quot; pages of results (depending on the context). For example, if the result set contains 50 results and the parameter \&quot;limit\&quot; is set to 25, the Links header will contain an URL for the first 25 results and the next 25 results. &lt;br&gt; &lt;br&gt; Some libraries such as python&#39;s &#x60;requests&#x60; can parse the header automatically and offer a convenient way of iterating through the results. For example: &#x60;&#x60;&#x60;python def get_all_results(url):     while url:         r &#x3D; requests.get(url)         r.raise_for_status()         for item in r.json()[&#39;results&#39;]:           yield item         url &#x3D; r.links.get(&#39;next&#39;, {}).get(&#39;url&#39;) &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LexiStatsApi;


LexiStatsApi apiInstance = new LexiStatsApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String corpus = "corpus_example"; // String | For corpora other than 'nmc' (New Monitor Corpus) please contact api@oxforddictionaries.com
String ngramSize = "ngramSize_example"; // String | the size of ngrams requested (1-4)
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String tokens = "a word"; // String | List of tokens to filter. The tokens are separated by spaces, the list items are separated by comma (e.g., for bigrams (n=2) tokens=this is,this was, this will)
String contains = "contains_example"; // String | Find ngrams containing the given token(s). Use comma or space as token separators; the order of tokens is irrelevant.
String punctuation = "punctuation_example"; // String | Flag specifying whether to lookup ngrams that include punctuation or not (possible values are \"true\" and \"false\"; default is \"false\")
String format = "oup"; // String | Option specifying whether tokens should be returned as a single string (option \"google\") or as a list of strings (option \"oup\")
Long minFrequency = 789L; // Long | Restrict the query to entries with frequency of at least `minFrequency`
Long maxFrequency = 789L; // Long | Restrict the query to entries with frequency of at most `maxFrequency`
Long minDocumentFrequency = 789L; // Long | Restrict the query to entries that appear in at least `minDocumentFrequency` documents
Long maxDocumentFrequency = 789L; // Long | Restrict the query to entries that appera in at most `maxDocumentFrequency` documents
String collate = "collate_example"; // String | collate the results by wordform, trueCase, lemma, lexicalCategory. Multiple values can be separated by commas (e.g., collate=trueCase,lemma,lexicalCategory).
String sort = "sort_example"; // String | sort the resulting list by wordform, trueCase, lemma, lexicalCategory, frequency, normalizedFrequency. Descending order is achieved by prepending the value with the minus sign ('-'). Multiple values can be separated by commas (e.g., sort=lexicalCategory,-frequency)
Long offset = 0L; // Long | pagination - results offset
Long limit = 100L; // Long | pagination - results limit
try {
    NgramsResult result = apiInstance.statsFrequencyNgramsSourceLangCorpusNgramSizeGet(sourceLang, corpus, ngramSize, appId, appKey, tokens, contains, punctuation, format, minFrequency, maxFrequency, minDocumentFrequency, maxDocumentFrequency, collate, sort, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LexiStatsApi#statsFrequencyNgramsSourceLangCorpusNgramSizeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code |
 **corpus** | **String**| For corpora other than &#39;nmc&#39; (New Monitor Corpus) please contact api@oxforddictionaries.com |
 **ngramSize** | **String**| the size of ngrams requested (1-4) |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **tokens** | **String**| List of tokens to filter. The tokens are separated by spaces, the list items are separated by comma (e.g., for bigrams (n&#x3D;2) tokens&#x3D;this is,this was, this will) | [optional] [default to a word]
 **contains** | **String**| Find ngrams containing the given token(s). Use comma or space as token separators; the order of tokens is irrelevant. | [optional]
 **punctuation** | **String**| Flag specifying whether to lookup ngrams that include punctuation or not (possible values are \&quot;true\&quot; and \&quot;false\&quot;; default is \&quot;false\&quot;) | [optional]
 **format** | **String**| Option specifying whether tokens should be returned as a single string (option \&quot;google\&quot;) or as a list of strings (option \&quot;oup\&quot;) | [optional] [default to oup]
 **minFrequency** | **Long**| Restrict the query to entries with frequency of at least &#x60;minFrequency&#x60; | [optional]
 **maxFrequency** | **Long**| Restrict the query to entries with frequency of at most &#x60;maxFrequency&#x60; | [optional]
 **minDocumentFrequency** | **Long**| Restrict the query to entries that appear in at least &#x60;minDocumentFrequency&#x60; documents | [optional]
 **maxDocumentFrequency** | **Long**| Restrict the query to entries that appera in at most &#x60;maxDocumentFrequency&#x60; documents | [optional]
 **collate** | **String**| collate the results by wordform, trueCase, lemma, lexicalCategory. Multiple values can be separated by commas (e.g., collate&#x3D;trueCase,lemma,lexicalCategory). | [optional]
 **sort** | **String**| sort the resulting list by wordform, trueCase, lemma, lexicalCategory, frequency, normalizedFrequency. Descending order is achieved by prepending the value with the minus sign (&#39;-&#39;). Multiple values can be separated by commas (e.g., sort&#x3D;lexicalCategory,-frequency) | [optional]
 **offset** | **Long**| pagination - results offset | [optional] [default to 0]
 **limit** | **Long**| pagination - results limit | [optional] [default to 100]

### Return type

[**NgramsResult**](NgramsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/csv

<a name="statsFrequencyWordSourceLangGet"></a>
# **statsFrequencyWordSourceLangGet**
> StatsWordResult statsFrequencyWordSourceLangGet(sourceLang, appId, appKey, corpus, wordform, trueCase, lemma, lexicalCategory)

Retrieve the frequency of a word derived from a corpus.

This endpoint provides the frequency of a given word. When multiple database records match the query parameters, the returned frequency is the sum of the individual frequencies. For example, if the query parameters are lemma&#x3D;test, the returned frequency will include the verb \&quot;test\&quot;, the noun \&quot;test\&quot; and the adjective \&quot;test\&quot; in all forms (Test, tested, testing, etc.) &lt;br&gt; &lt;br&gt; If you are interested in the frequency of the word \&quot;test\&quot; but want to exclude other forms (e.g., tested) use the option trueCase&#x3D;test. Normally, the word \&quot;test\&quot; will be spelt with a capital letter at the beginning of a sentence. The option trueCase will ignore this and it will count \&quot;Test\&quot; and \&quot;test\&quot; as the same token. If you are interested in frequencies of \&quot;Test\&quot; and \&quot;test\&quot;, use the option wordform&#x3D;test or wordform&#x3D;Test. Note that trueCase is not just a lower case of the word as some words are genuinely spelt with a capital letter such as the word \&quot;press\&quot; in Oxford University Press. &lt;br&gt; &lt;br&gt; Parameters can be provided in PATH, GET or POST (form or json). The parameters in PATH are overriden by parameters in GET, POST and json (in that order). In PATH, individual options are separated by semicolon and values are separated by commas (where multiple values can be used). Examples: * PATH: /lemma&#x3D;test;lexicalCategory&#x3D;noun * GET: /?lemma&#x3D;test&amp;lexicalCategory&#x3D;noun * POST (json):    &#x60;&#x60;&#x60;javascript     {       \&quot;lemma\&quot;: \&quot;test\&quot;,       \&quot;lexicalCategory\&quot;: \&quot;noun\&quot;     }   &#x60;&#x60;&#x60;  &lt;br&gt; One of the options wordform/trueCase/lemma/lexicalCategory has to be provided. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LexiStatsApi;


LexiStatsApi apiInstance = new LexiStatsApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String corpus = "nmc"; // String | For corpora other than 'nmc' (New Monitor Corpus) please contact api@oxforddictionaries.com
String wordform = "wordform_example"; // String | The written form of the word to look up (preserving case e.g., Books vs books)
String trueCase = "trueCase_example"; // String | The written form of the word to look up with normalised case (Books --> books)
String lemma = "test"; // String | The lemma of the word to look up (e.g., Book, booked, books all have the lemma \"book\")
String lexicalCategory = "lexicalCategory_example"; // String | The lexical category of the word(s) to look up (e.g., noun or verb)
try {
    StatsWordResult result = apiInstance.statsFrequencyWordSourceLangGet(sourceLang, appId, appKey, corpus, wordform, trueCase, lemma, lexicalCategory);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LexiStatsApi#statsFrequencyWordSourceLangGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **corpus** | **String**| For corpora other than &#39;nmc&#39; (New Monitor Corpus) please contact api@oxforddictionaries.com | [optional] [default to nmc]
 **wordform** | **String**| The written form of the word to look up (preserving case e.g., Books vs books) | [optional]
 **trueCase** | **String**| The written form of the word to look up with normalised case (Books --&gt; books) | [optional]
 **lemma** | **String**| The lemma of the word to look up (e.g., Book, booked, books all have the lemma \&quot;book\&quot;) | [optional] [default to test]
 **lexicalCategory** | **String**| The lexical category of the word(s) to look up (e.g., noun or verb) | [optional]

### Return type

[**StatsWordResult**](StatsWordResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/csv

<a name="statsFrequencyWordsSourceLangGet"></a>
# **statsFrequencyWordsSourceLangGet**
> StatsWordResultList statsFrequencyWordsSourceLangGet(sourceLang, appId, appKey, corpus, wordform, trueCase, lemma, lexicalCategory, grammaticalFeatures, sort, collate, minFrequency, maxFrequency, minNormalizedFrequency, maxNormalizedFrequency, offset, limit)

Retrieve a list of frequencies of a word/words derived from a corpus.

This endpoint provides a list of frequencies for a given word or words. Unlike the /word/ endpoint, the results are split into the smallest units. &lt;br&gt; &lt;br&gt; To exclude a specific value, prepend it with the minus sign (&#39;-&#39;). For example, to get frequencies of the lemma &#39;happy&#39; but exclude superlative forms (i.e., happiest) you could use options &#39;lemma&#x3D;happy;grammaticalFeatures&#x3D;-degreeType:superlative&#39;. &lt;br&gt; &lt;br&gt; Parameters can be provided in PATH, GET or POST (form or json). The parameters in PATH are overridden by parameters in GET, POST and json (in that order). In PATH, individual options are separated by semicolon and values are separated by commas (where multiple values can be used). &lt;br&gt; &lt;br&gt; The parameters wordform/trueCase/lemma/lexicalCategory also exist in a plural form, taking a lists of items. Examples: * PATH: /wordforms&#x3D;happy,happier,happiest * GET: /?wordforms&#x3D;happy&amp;wordforms&#x3D;happier&amp;wordforms&#x3D;happiest * POST (json): &#x60;&#x60;&#x60;javascript   {     \&quot;wordforms\&quot;: [\&quot;happy\&quot;, \&quot;happier\&quot;, \&quot;happiest\&quot;]   } &#x60;&#x60;&#x60; A mor complex example of retrieving frequencies of multiple lemmas: &#x60;&#x60;&#x60;   {       \&quot;lemmas\&quot;: [\&quot;happy\&quot;, \&quot;content\&quot;, \&quot;cheerful\&quot;, \&quot;cheery\&quot;, \&quot;merry\&quot;, \&quot;joyful\&quot;, \&quot;ecstatic\&quot;],       \&quot;grammaticalFeatures\&quot;: {           \&quot;adjectiveFunctionType\&quot;: \&quot;predicative\&quot;       },       \&quot;lexicalCategory\&quot;: \&quot;adjective\&quot;,       \&quot;sort\&quot;: [\&quot;lemma\&quot;, \&quot;-frequency\&quot;]   } &#x60;&#x60;&#x60; Some queries with \&quot;collate\&quot; or \&quot;sort\&quot; can exceed the 30s timeout, in which case the API will return an error message with status code 503. You mitigate this by providing additional restrictions such as \&quot;minFrequency\&quot; and \&quot;maxFrequency\&quot;. &lt;br&gt; &lt;br&gt; You can use the parameters \&quot;offset\&quot; and \&quot;limit\&quot; to paginate through large result sets. For convenience, the HTTP header \&quot;Link\&quot; is set on the response to provide links to \&quot;first\&quot;, \&quot;self\&quot;, \&quot;next\&quot;, \&quot;prev\&quot; and \&quot;last\&quot; pages of results (depending on the context). For example, if the result set contains 50 results and the parameter \&quot;limit\&quot; is set to 25, the Links header will contain an URL for the first 25 results and the next 25 results. &lt;br&gt; &lt;br&gt; Some libraries such as python&#39;s &#x60;requests&#x60; can parse the header automatically and offer a convenient way of iterating through the results. For example: &#x60;&#x60;&#x60;python def get_all_results(url):     while url:         r &#x3D; requests.get(url)         r.raise_for_status()         for item in r.json()[&#39;results&#39;]:           yield item         url &#x3D; r.links.get(&#39;next&#39;, {}).get(&#39;url&#39;) &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LexiStatsApi;


LexiStatsApi apiInstance = new LexiStatsApi();
String sourceLang = "sourceLang_example"; // String | IANA language code
String appId = "5037d509"; // String | App ID Authentication Parameter
String appKey = "4dc1aebaa63721f0f8e79a55e2514bc7"; // String | App Key Authentication Parameter
String corpus = "nmc"; // String | For corpora other than 'nmc' (New Monitor Corpus) please contact api@oxforddictionaries.com
String wordform = "wordform_example"; // String | The written form of the word to look up (preserving case e.g., Book vs book)
String trueCase = "trueCase_example"; // String | The written form of the word to look up with normalised case (Books --> books)
String lemma = "test"; // String | The lemma of the word to look up (e.g., Book, booked, books all have the lemma \"book\")
String lexicalCategory = "lexicalCategory_example"; // String | The lexical category of the word(s) to look up (e.g., adjective or noun)
String grammaticalFeatures = "grammaticalFeatures_example"; // String | The grammatical features of the word(s) to look up entered as a list of k:v (e.g., degree_type:comparative)
String sort = "sort_example"; // String | sort the resulting list by wordform, trueCase, lemma, lexicalCategory, frequency, normalizedFrequency. Descending order is achieved by prepending the value with the minus sign ('-'). Multiple values can be separated by commas (e.g., sort=lexicalCategory,-frequency)
String collate = "collate_example"; // String | collate the results by wordform, trueCase, lemma, lexicalCategory. Multiple values can be separated by commas (e.g., collate=trueCase,lemma,lexicalCategory).
Long minFrequency = 789L; // Long | Restrict the query to entries with frequency of at least `minFrequency`
Long maxFrequency = 789L; // Long | Restrict the query to entries with frequency of at most `maxFrequency`
Float minNormalizedFrequency = 3.4F; // Float | Restrict the query to entries with frequency of at least `minNormalizedFrequency`
Float maxNormalizedFrequency = 3.4F; // Float | Restrict the query to entries with frequency of at most `maxNormalizedFrequency`
Long offset = 0L; // Long | pagination - results offset
Long limit = 100L; // Long | pagination - results limit
try {
    StatsWordResultList result = apiInstance.statsFrequencyWordsSourceLangGet(sourceLang, appId, appKey, corpus, wordform, trueCase, lemma, lexicalCategory, grammaticalFeatures, sort, collate, minFrequency, maxFrequency, minNormalizedFrequency, maxNormalizedFrequency, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LexiStatsApi#statsFrequencyWordsSourceLangGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceLang** | **String**| IANA language code |
 **appId** | **String**| App ID Authentication Parameter | [default to 5037d509]
 **appKey** | **String**| App Key Authentication Parameter | [default to 4dc1aebaa63721f0f8e79a55e2514bc7]
 **corpus** | **String**| For corpora other than &#39;nmc&#39; (New Monitor Corpus) please contact api@oxforddictionaries.com | [optional] [default to nmc]
 **wordform** | **String**| The written form of the word to look up (preserving case e.g., Book vs book) | [optional]
 **trueCase** | **String**| The written form of the word to look up with normalised case (Books --&gt; books) | [optional]
 **lemma** | **String**| The lemma of the word to look up (e.g., Book, booked, books all have the lemma \&quot;book\&quot;) | [optional] [default to test]
 **lexicalCategory** | **String**| The lexical category of the word(s) to look up (e.g., adjective or noun) | [optional]
 **grammaticalFeatures** | **String**| The grammatical features of the word(s) to look up entered as a list of k:v (e.g., degree_type:comparative) | [optional]
 **sort** | **String**| sort the resulting list by wordform, trueCase, lemma, lexicalCategory, frequency, normalizedFrequency. Descending order is achieved by prepending the value with the minus sign (&#39;-&#39;). Multiple values can be separated by commas (e.g., sort&#x3D;lexicalCategory,-frequency) | [optional]
 **collate** | **String**| collate the results by wordform, trueCase, lemma, lexicalCategory. Multiple values can be separated by commas (e.g., collate&#x3D;trueCase,lemma,lexicalCategory). | [optional]
 **minFrequency** | **Long**| Restrict the query to entries with frequency of at least &#x60;minFrequency&#x60; | [optional]
 **maxFrequency** | **Long**| Restrict the query to entries with frequency of at most &#x60;maxFrequency&#x60; | [optional]
 **minNormalizedFrequency** | **Float**| Restrict the query to entries with frequency of at least &#x60;minNormalizedFrequency&#x60; | [optional]
 **maxNormalizedFrequency** | **Float**| Restrict the query to entries with frequency of at most &#x60;maxNormalizedFrequency&#x60; | [optional]
 **offset** | **Long**| pagination - results offset | [optional] [default to 0]
 **limit** | **Long**| pagination - results limit | [optional] [default to 100]

### Return type

[**StatsWordResultList**](StatsWordResultList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/csv

