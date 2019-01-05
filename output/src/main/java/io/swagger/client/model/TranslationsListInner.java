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
import io.swagger.client.model.Arrayofstrings;
import io.swagger.client.model.CategorizedTextList;
import io.swagger.client.model.GrammaticalFeaturesList;


/**
 * TranslationsListInner
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-05T18:00:32.106-05:00")
public class TranslationsListInner   {
  @SerializedName("domains")
  private Arrayofstrings domains = null;

  @SerializedName("grammaticalFeatures")
  private GrammaticalFeaturesList grammaticalFeatures = null;

  @SerializedName("language")
  private String language = null;

  @SerializedName("notes")
  private CategorizedTextList notes = null;

  @SerializedName("regions")
  private Arrayofstrings regions = null;

  @SerializedName("registers")
  private Arrayofstrings registers = null;

  @SerializedName("text")
  private String text = null;

  public TranslationsListInner domains(Arrayofstrings domains) {
    this.domains = domains;
    return this;
  }

   /**
   * A subject, discipline, or branch of knowledge particular to the translation
   * @return domains
  **/
  @ApiModelProperty(example = "null", value = "A subject, discipline, or branch of knowledge particular to the translation")
  public Arrayofstrings getDomains() {
    return domains;
  }

  public void setDomains(Arrayofstrings domains) {
    this.domains = domains;
  }

  public TranslationsListInner grammaticalFeatures(GrammaticalFeaturesList grammaticalFeatures) {
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

  public TranslationsListInner language(String language) {
    this.language = language;
    return this;
  }

   /**
   * IANA language code specifying the language of the translation
   * @return language
  **/
  @ApiModelProperty(example = "null", required = true, value = "IANA language code specifying the language of the translation")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public TranslationsListInner notes(CategorizedTextList notes) {
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

  public TranslationsListInner regions(Arrayofstrings regions) {
    this.regions = regions;
    return this;
  }

   /**
   * A particular area in which the translation occurs, e.g. 'Great Britain'
   * @return regions
  **/
  @ApiModelProperty(example = "null", value = "A particular area in which the translation occurs, e.g. 'Great Britain'")
  public Arrayofstrings getRegions() {
    return regions;
  }

  public void setRegions(Arrayofstrings regions) {
    this.regions = regions;
  }

  public TranslationsListInner registers(Arrayofstrings registers) {
    this.registers = registers;
    return this;
  }

   /**
   * A level of language usage, typically with respect to formality. e.g. 'offensive', 'informal'
   * @return registers
  **/
  @ApiModelProperty(example = "null", value = "A level of language usage, typically with respect to formality. e.g. 'offensive', 'informal'")
  public Arrayofstrings getRegisters() {
    return registers;
  }

  public void setRegisters(Arrayofstrings registers) {
    this.registers = registers;
  }

  public TranslationsListInner text(String text) {
    this.text = text;
    return this;
  }

   /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranslationsListInner translationsListInner = (TranslationsListInner) o;
    return Objects.equals(this.domains, translationsListInner.domains) &&
        Objects.equals(this.grammaticalFeatures, translationsListInner.grammaticalFeatures) &&
        Objects.equals(this.language, translationsListInner.language) &&
        Objects.equals(this.notes, translationsListInner.notes) &&
        Objects.equals(this.regions, translationsListInner.regions) &&
        Objects.equals(this.registers, translationsListInner.registers) &&
        Objects.equals(this.text, translationsListInner.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domains, grammaticalFeatures, language, notes, regions, registers, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslationsListInner {\n");
    
    sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
    sb.append("    grammaticalFeatures: ").append(toIndentedString(grammaticalFeatures)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    registers: ").append(toIndentedString(registers)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

