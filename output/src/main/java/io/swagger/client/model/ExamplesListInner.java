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
import io.swagger.client.model.TranslationsList;


/**
 * ExamplesListInner
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-05T18:00:32.106-05:00")
public class ExamplesListInner   {
  @SerializedName("definitions")
  private Arrayofstrings definitions = null;

  @SerializedName("domains")
  private Arrayofstrings domains = null;

  @SerializedName("notes")
  private CategorizedTextList notes = null;

  @SerializedName("regions")
  private Arrayofstrings regions = null;

  @SerializedName("registers")
  private Arrayofstrings registers = null;

  @SerializedName("senseIds")
  private Arrayofstrings senseIds = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("translations")
  private TranslationsList translations = null;

  public ExamplesListInner definitions(Arrayofstrings definitions) {
    this.definitions = definitions;
    return this;
  }

   /**
   * A list of statements of the exact meaning of a word
   * @return definitions
  **/
  @ApiModelProperty(example = "null", value = "A list of statements of the exact meaning of a word")
  public Arrayofstrings getDefinitions() {
    return definitions;
  }

  public void setDefinitions(Arrayofstrings definitions) {
    this.definitions = definitions;
  }

  public ExamplesListInner domains(Arrayofstrings domains) {
    this.domains = domains;
    return this;
  }

   /**
   * A subject, discipline, or branch of knowledge particular to the Sense
   * @return domains
  **/
  @ApiModelProperty(example = "null", value = "A subject, discipline, or branch of knowledge particular to the Sense")
  public Arrayofstrings getDomains() {
    return domains;
  }

  public void setDomains(Arrayofstrings domains) {
    this.domains = domains;
  }

  public ExamplesListInner notes(CategorizedTextList notes) {
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

  public ExamplesListInner regions(Arrayofstrings regions) {
    this.regions = regions;
    return this;
  }

   /**
   * A particular area in which the pronunciation occurs, e.g. 'Great Britain'
   * @return regions
  **/
  @ApiModelProperty(example = "null", value = "A particular area in which the pronunciation occurs, e.g. 'Great Britain'")
  public Arrayofstrings getRegions() {
    return regions;
  }

  public void setRegions(Arrayofstrings regions) {
    this.regions = regions;
  }

  public ExamplesListInner registers(Arrayofstrings registers) {
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

  public ExamplesListInner senseIds(Arrayofstrings senseIds) {
    this.senseIds = senseIds;
    return this;
  }

   /**
   * The list of sense identifiers related to the example. Provided in the sentences endpoint only.
   * @return senseIds
  **/
  @ApiModelProperty(example = "null", value = "The list of sense identifiers related to the example. Provided in the sentences endpoint only.")
  public Arrayofstrings getSenseIds() {
    return senseIds;
  }

  public void setSenseIds(Arrayofstrings senseIds) {
    this.senseIds = senseIds;
  }

  public ExamplesListInner text(String text) {
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

  public ExamplesListInner translations(TranslationsList translations) {
    this.translations = translations;
    return this;
  }

   /**
   * Get translations
   * @return translations
  **/
  @ApiModelProperty(example = "null", value = "")
  public TranslationsList getTranslations() {
    return translations;
  }

  public void setTranslations(TranslationsList translations) {
    this.translations = translations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExamplesListInner examplesListInner = (ExamplesListInner) o;
    return Objects.equals(this.definitions, examplesListInner.definitions) &&
        Objects.equals(this.domains, examplesListInner.domains) &&
        Objects.equals(this.notes, examplesListInner.notes) &&
        Objects.equals(this.regions, examplesListInner.regions) &&
        Objects.equals(this.registers, examplesListInner.registers) &&
        Objects.equals(this.senseIds, examplesListInner.senseIds) &&
        Objects.equals(this.text, examplesListInner.text) &&
        Objects.equals(this.translations, examplesListInner.translations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(definitions, domains, notes, regions, registers, senseIds, text, translations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExamplesListInner {\n");
    
    sb.append("    definitions: ").append(toIndentedString(definitions)).append("\n");
    sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    registers: ").append(toIndentedString(registers)).append("\n");
    sb.append("    senseIds: ").append(toIndentedString(senseIds)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    translations: ").append(toIndentedString(translations)).append("\n");
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

