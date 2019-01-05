/**
 * 
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.11.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ArrayOfRelatedEntries;
import io.swagger.client.model.CategorizedTextList;
import io.swagger.client.model.Entry;
import io.swagger.client.model.GrammaticalFeaturesList;
import io.swagger.client.model.PronunciationsList;
import io.swagger.client.model.VariantFormsList;
import java.util.ArrayList;
import java.util.List;


/**
 * Description of an entry for a particular part of speech
 */
@ApiModel(description = "Description of an entry for a particular part of speech")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-05T18:00:32.106-05:00")
public class LexicalEntry   {
  @SerializedName("derivativeOf")
  private ArrayOfRelatedEntries derivativeOf = null;

  @SerializedName("derivatives")
  private ArrayOfRelatedEntries derivatives = null;

  @SerializedName("entries")
  private List<Entry> entries = new ArrayList<Entry>();

  @SerializedName("grammaticalFeatures")
  private GrammaticalFeaturesList grammaticalFeatures = null;

  @SerializedName("language")
  private String language = null;

  @SerializedName("lexicalCategory")
  private String lexicalCategory = null;

  @SerializedName("notes")
  private CategorizedTextList notes = null;

  @SerializedName("pronunciations")
  private PronunciationsList pronunciations = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("variantForms")
  private VariantFormsList variantForms = null;

  public LexicalEntry derivativeOf(ArrayOfRelatedEntries derivativeOf) {
    this.derivativeOf = derivativeOf;
    return this;
  }

   /**
   * Other words from which this one derives
   * @return derivativeOf
  **/
  @ApiModelProperty(example = "null", value = "Other words from which this one derives")
  public ArrayOfRelatedEntries getDerivativeOf() {
    return derivativeOf;
  }

  public void setDerivativeOf(ArrayOfRelatedEntries derivativeOf) {
    this.derivativeOf = derivativeOf;
  }

  public LexicalEntry derivatives(ArrayOfRelatedEntries derivatives) {
    this.derivatives = derivatives;
    return this;
  }

   /**
   * Other words from which their Sense derives
   * @return derivatives
  **/
  @ApiModelProperty(example = "null", value = "Other words from which their Sense derives")
  public ArrayOfRelatedEntries getDerivatives() {
    return derivatives;
  }

  public void setDerivatives(ArrayOfRelatedEntries derivatives) {
    this.derivatives = derivatives;
  }

  public LexicalEntry entries(List<Entry> entries) {
    this.entries = entries;
    return this;
  }

  public LexicalEntry addEntriesItem(Entry entriesItem) {
    this.entries.add(entriesItem);
    return this;
  }

   /**
   * Get entries
   * @return entries
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

  public LexicalEntry grammaticalFeatures(GrammaticalFeaturesList grammaticalFeatures) {
    this.grammaticalFeatures = grammaticalFeatures;
    return this;
  }

   /**
   * Get grammaticalFeatures
   * @return grammaticalFeatures
  **/
  @ApiModelProperty(example = "null", value = "")
  public GrammaticalFeaturesList getGrammaticalFeatures() {
    return grammaticalFeatures;
  }

  public void setGrammaticalFeatures(GrammaticalFeaturesList grammaticalFeatures) {
    this.grammaticalFeatures = grammaticalFeatures;
  }

  public LexicalEntry language(String language) {
    this.language = language;
    return this;
  }

   /**
   * IANA language code
   * @return language
  **/
  @ApiModelProperty(example = "null", required = true, value = "IANA language code")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public LexicalEntry lexicalCategory(String lexicalCategory) {
    this.lexicalCategory = lexicalCategory;
    return this;
  }

   /**
   * A linguistic category of words (or more precisely lexical items), generally defined by the syntactic or morphological behaviour of the lexical item in question, such as noun or verb
   * @return lexicalCategory
  **/
  @ApiModelProperty(example = "null", required = true, value = "A linguistic category of words (or more precisely lexical items), generally defined by the syntactic or morphological behaviour of the lexical item in question, such as noun or verb")
  public String getLexicalCategory() {
    return lexicalCategory;
  }

  public void setLexicalCategory(String lexicalCategory) {
    this.lexicalCategory = lexicalCategory;
  }

  public LexicalEntry notes(CategorizedTextList notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Get notes
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "")
  public CategorizedTextList getNotes() {
    return notes;
  }

  public void setNotes(CategorizedTextList notes) {
    this.notes = notes;
  }

  public LexicalEntry pronunciations(PronunciationsList pronunciations) {
    this.pronunciations = pronunciations;
    return this;
  }

   /**
   * Get pronunciations
   * @return pronunciations
  **/
  @ApiModelProperty(example = "null", value = "")
  public PronunciationsList getPronunciations() {
    return pronunciations;
  }

  public void setPronunciations(PronunciationsList pronunciations) {
    this.pronunciations = pronunciations;
  }

  public LexicalEntry text(String text) {
    this.text = text;
    return this;
  }

   /**
   * A given written or spoken realisation of a an entry.
   * @return text
  **/
  @ApiModelProperty(example = "null", required = true, value = "A given written or spoken realisation of a an entry.")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LexicalEntry variantForms(VariantFormsList variantForms) {
    this.variantForms = variantForms;
    return this;
  }

   /**
   * Various words that are used interchangeably depending on the context, e.g 'a' and 'an'
   * @return variantForms
  **/
  @ApiModelProperty(example = "null", value = "Various words that are used interchangeably depending on the context, e.g 'a' and 'an'")
  public VariantFormsList getVariantForms() {
    return variantForms;
  }

  public void setVariantForms(VariantFormsList variantForms) {
    this.variantForms = variantForms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LexicalEntry lexicalEntry = (LexicalEntry) o;
    return Objects.equals(this.derivativeOf, lexicalEntry.derivativeOf) &&
        Objects.equals(this.derivatives, lexicalEntry.derivatives) &&
        Objects.equals(this.entries, lexicalEntry.entries) &&
        Objects.equals(this.grammaticalFeatures, lexicalEntry.grammaticalFeatures) &&
        Objects.equals(this.language, lexicalEntry.language) &&
        Objects.equals(this.lexicalCategory, lexicalEntry.lexicalCategory) &&
        Objects.equals(this.notes, lexicalEntry.notes) &&
        Objects.equals(this.pronunciations, lexicalEntry.pronunciations) &&
        Objects.equals(this.text, lexicalEntry.text) &&
        Objects.equals(this.variantForms, lexicalEntry.variantForms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(derivativeOf, derivatives, entries, grammaticalFeatures, language, lexicalCategory, notes, pronunciations, text, variantForms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LexicalEntry {\n");
    
    sb.append("    derivativeOf: ").append(toIndentedString(derivativeOf)).append("\n");
    sb.append("    derivatives: ").append(toIndentedString(derivatives)).append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
    sb.append("    grammaticalFeatures: ").append(toIndentedString(grammaticalFeatures)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    lexicalCategory: ").append(toIndentedString(lexicalCategory)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    pronunciations: ").append(toIndentedString(pronunciations)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    variantForms: ").append(toIndentedString(variantForms)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

