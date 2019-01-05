# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DictionaryEntriesApi;

import java.io.File;
import java.util.*;

public class DictionaryEntriesApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://od-api-demo.oxforddictionaries.com:443/api/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DictionaryEntriesApi* | [**entriesSourceLangWordIdFiltersGet**](docs/DictionaryEntriesApi.md#entriesSourceLangWordIdFiltersGet) | **GET** /entries/{source_lang}/{word_id}/{filters} | Apply filters to response
*DictionaryEntriesApi* | [**entriesSourceLangWordIdGet**](docs/DictionaryEntriesApi.md#entriesSourceLangWordIdGet) | **GET** /entries/{source_lang}/{word_id} | Retrieve dictionary information for a given word
*DictionaryEntriesApi* | [**entriesSourceLangWordIdRegionsregionGet**](docs/DictionaryEntriesApi.md#entriesSourceLangWordIdRegionsregionGet) | **GET** /entries/{source_lang}/{word_id}/regions&#x3D;{region} | Specify GB or US dictionary for English entry search
*LemmatronApi* | [**inflectionsSourceLangWordIdFiltersGet**](docs/LemmatronApi.md#inflectionsSourceLangWordIdFiltersGet) | **GET** /inflections/{source_lang}/{word_id}/{filters} | Apply optional filters to Lemmatron response
*LemmatronApi* | [**inflectionsSourceLangWordIdGet**](docs/LemmatronApi.md#inflectionsSourceLangWordIdGet) | **GET** /inflections/{source_lang}/{word_id} | Check a word exists in the dictionary and retrieve its root form
*LexiStatsApi* | [**statsFrequencyNgramsSourceLangCorpusNgramSizeGet**](docs/LexiStatsApi.md#statsFrequencyNgramsSourceLangCorpusNgramSizeGet) | **GET** /stats/frequency/ngrams/{source_lang}/{corpus}/{ngram-size}/ | Retrieve the frequency of ngrams (1-4) derived from a corpus
*LexiStatsApi* | [**statsFrequencyWordSourceLangGet**](docs/LexiStatsApi.md#statsFrequencyWordSourceLangGet) | **GET** /stats/frequency/word/{source_lang}/ | Retrieve the frequency of a word derived from a corpus.
*LexiStatsApi* | [**statsFrequencyWordsSourceLangGet**](docs/LexiStatsApi.md#statsFrequencyWordsSourceLangGet) | **GET** /stats/frequency/words/{source_lang}/ | Retrieve a list of frequencies of a word/words derived from a corpus.
*SearchApi* | [**searchSourceLangGet**](docs/SearchApi.md#searchSourceLangGet) | **GET** /search/{source_lang} | Retrieve possible matches to input
*SearchApi* | [**searchSourceSearchLanguageTranslationstargetSearchLanguageGet**](docs/SearchApi.md#searchSourceSearchLanguageTranslationstargetSearchLanguageGet) | **GET** /search/{source_search_language}/translations&#x3D;{target_search_language} | Retrieve possible translation matches to input
*TheSentenceDictionaryApi* | [**entriesSourceLanguageWordIdSentencesGet**](docs/TheSentenceDictionaryApi.md#entriesSourceLanguageWordIdSentencesGet) | **GET** /entries/{source_language}/{word_id}/sentences | Retrieve corpus sentences for a given word
*ThesaurusApi* | [**entriesSourceLangWordIdAntonymsGet**](docs/ThesaurusApi.md#entriesSourceLangWordIdAntonymsGet) | **GET** /entries/{source_lang}/{word_id}/antonyms | Retrieve words that mean the opposite
*ThesaurusApi* | [**entriesSourceLangWordIdSynonymsGet**](docs/ThesaurusApi.md#entriesSourceLangWordIdSynonymsGet) | **GET** /entries/{source_lang}/{word_id}/synonyms | Retrieve words that are similar
*ThesaurusApi* | [**entriesSourceLangWordIdSynonymsantonymsGet**](docs/ThesaurusApi.md#entriesSourceLangWordIdSynonymsantonymsGet) | **GET** /entries/{source_lang}/{word_id}/synonyms;antonyms | Retrieve synonyms and antonyms for a given word
*TranslationApi* | [**entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet**](docs/TranslationApi.md#entriesSourceTranslationLanguageWordIdTranslationstargetTranslationLanguageGet) | **GET** /entries/{source_translation_language}/{word_id}/translations&#x3D;{target_translation_language} | Retrieve translation for a given word
*UtilityApi* | [**domainsSourceDomainsLanguageTargetDomainsLanguageGet**](docs/UtilityApi.md#domainsSourceDomainsLanguageTargetDomainsLanguageGet) | **GET** /domains/{source_domains_language}/{target_domains_language} | Lists available domains in a bilingual dataset
*UtilityApi* | [**domainsSourceLanguageGet**](docs/UtilityApi.md#domainsSourceLanguageGet) | **GET** /domains/{source_language} | Lists available domains in a monolingual dataset
*UtilityApi* | [**filtersEndpointGet**](docs/UtilityApi.md#filtersEndpointGet) | **GET** /filters/{endpoint} | Lists available filters for specific endpoint
*UtilityApi* | [**filtersGet**](docs/UtilityApi.md#filtersGet) | **GET** /filters | Lists available filters
*UtilityApi* | [**grammaticalFeaturesSourceLanguageGet**](docs/UtilityApi.md#grammaticalFeaturesSourceLanguageGet) | **GET** /grammaticalFeatures/{source_language} | Lists available grammatical features in a dataset
*UtilityApi* | [**languagesGet**](docs/UtilityApi.md#languagesGet) | **GET** /languages | Lists available dictionaries
*UtilityApi* | [**lexicalcategoriesLanguageGet**](docs/UtilityApi.md#lexicalcategoriesLanguageGet) | **GET** /lexicalcategories/{language} | Lists available lexical categories in a dataset
*UtilityApi* | [**regionsSourceLanguageGet**](docs/UtilityApi.md#regionsSourceLanguageGet) | **GET** /regions/{source_language} | Lists available regions in a monolingual dataset
*UtilityApi* | [**registersSourceLanguageGet**](docs/UtilityApi.md#registersSourceLanguageGet) | **GET** /registers/{source_language} | Lists available registers in a  monolingual dataset
*UtilityApi* | [**registersSourceRegisterLanguageTargetRegisterLanguageGet**](docs/UtilityApi.md#registersSourceRegisterLanguageTargetRegisterLanguageGet) | **GET** /registers/{source_register_language}/{target_register_language} | Lists available registers in a bilingual dataset
*WordlistApi* | [**wordlistSourceLangFiltersAdvancedGet**](docs/WordlistApi.md#wordlistSourceLangFiltersAdvancedGet) | **GET** /wordlist/{source_lang}/{filters_advanced} | Retrieve list of words for category with advanced options
*WordlistApi* | [**wordlistSourceLangFiltersBasicGet**](docs/WordlistApi.md#wordlistSourceLangFiltersBasicGet) | **GET** /wordlist/{source_lang}/{filters_basic} | Retrieve a list of words in a category


## Documentation for Models

 - [ArrayOfRelatedEntries](docs/ArrayOfRelatedEntries.md)
 - [ArrayOfRelatedEntriesInner](docs/ArrayOfRelatedEntriesInner.md)
 - [Arrayofstrings](docs/Arrayofstrings.md)
 - [CategorizedTextList](docs/CategorizedTextList.md)
 - [CategorizedTextListInner](docs/CategorizedTextListInner.md)
 - [CrossReferencesList](docs/CrossReferencesList.md)
 - [CrossReferencesListInner](docs/CrossReferencesListInner.md)
 - [Entry](docs/Entry.md)
 - [ExamplesList](docs/ExamplesList.md)
 - [ExamplesListInner](docs/ExamplesListInner.md)
 - [Filters](docs/Filters.md)
 - [FiltersResults](docs/FiltersResults.md)
 - [GrammaticalFeaturesList](docs/GrammaticalFeaturesList.md)
 - [GrammaticalFeaturesListInner](docs/GrammaticalFeaturesListInner.md)
 - [HeadwordEntry](docs/HeadwordEntry.md)
 - [HeadwordLemmatron](docs/HeadwordLemmatron.md)
 - [HeadwordThesaurus](docs/HeadwordThesaurus.md)
 - [InflectionsList](docs/InflectionsList.md)
 - [InflectionsListInner](docs/InflectionsListInner.md)
 - [Languages](docs/Languages.md)
 - [LanguagesResults](docs/LanguagesResults.md)
 - [LanguagesSourceLanguage](docs/LanguagesSourceLanguage.md)
 - [LanguagesTargetLanguage](docs/LanguagesTargetLanguage.md)
 - [Lemmatron](docs/Lemmatron.md)
 - [LemmatronLexicalEntry](docs/LemmatronLexicalEntry.md)
 - [LexicalEntry](docs/LexicalEntry.md)
 - [NgramsResult](docs/NgramsResult.md)
 - [NgramsResultResults](docs/NgramsResultResults.md)
 - [PronunciationsList](docs/PronunciationsList.md)
 - [PronunciationsListInner](docs/PronunciationsListInner.md)
 - [Regions](docs/Regions.md)
 - [RetrieveEntry](docs/RetrieveEntry.md)
 - [Sense](docs/Sense.md)
 - [SentencesEntry](docs/SentencesEntry.md)
 - [SentencesLexicalEntry](docs/SentencesLexicalEntry.md)
 - [SentencesResults](docs/SentencesResults.md)
 - [StatsWordResult](docs/StatsWordResult.md)
 - [StatsWordResultList](docs/StatsWordResultList.md)
 - [StatsWordResultListResults](docs/StatsWordResultListResults.md)
 - [StatsWordResultResult](docs/StatsWordResultResult.md)
 - [SynonymsAntonyms](docs/SynonymsAntonyms.md)
 - [SynonymsAntonymsInner](docs/SynonymsAntonymsInner.md)
 - [Thesaurus](docs/Thesaurus.md)
 - [ThesaurusEntry](docs/ThesaurusEntry.md)
 - [ThesaurusLexicalEntry](docs/ThesaurusLexicalEntry.md)
 - [ThesaurusLink](docs/ThesaurusLink.md)
 - [ThesaurusSense](docs/ThesaurusSense.md)
 - [TranslationsList](docs/TranslationsList.md)
 - [TranslationsListInner](docs/TranslationsListInner.md)
 - [UtilityLabels](docs/UtilityLabels.md)
 - [UtilityLabelsResults](docs/UtilityLabelsResults.md)
 - [VariantFormsList](docs/VariantFormsList.md)
 - [VariantFormsListInner](docs/VariantFormsListInner.md)
 - [Wordlist](docs/Wordlist.md)
 - [WordlistResults](docs/WordlistResults.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



