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
import io.swagger.client.model.HeadwordThesaurus;
import java.util.ArrayList;
import java.util.List;


/**
 * Schema for thesaurus endpoint
 */
@ApiModel(description = "Schema for thesaurus endpoint")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-05T18:00:32.106-05:00")
public class Thesaurus   {
  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("results")
  private List<HeadwordThesaurus> results = new ArrayList<HeadwordThesaurus>();

  public Thesaurus metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Additional Information provided by OUP
   * @return metadata
  **/
  @ApiModelProperty(example = "null", value = "Additional Information provided by OUP")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  public Thesaurus results(List<HeadwordThesaurus> results) {
    this.results = results;
    return this;
  }

  public Thesaurus addResultsItem(HeadwordThesaurus resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * A list of found synonyms or antonyms
   * @return results
  **/
  @ApiModelProperty(example = "null", value = "A list of found synonyms or antonyms")
  public List<HeadwordThesaurus> getResults() {
    return results;
  }

  public void setResults(List<HeadwordThesaurus> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Thesaurus thesaurus = (Thesaurus) o;
    return Objects.equals(this.metadata, thesaurus.metadata) &&
        Objects.equals(this.results, thesaurus.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Thesaurus {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

