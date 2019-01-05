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


/**
 * CategorizedTextListInner
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-05T18:00:32.106-05:00")
public class CategorizedTextListInner   {
  @SerializedName("id")
  private String id = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("type")
  private String type = null;

  public CategorizedTextListInner id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The identifier of the word
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "The identifier of the word")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategorizedTextListInner text(String text) {
    this.text = text;
    return this;
  }

   /**
   * A note text
   * @return text
  **/
  @ApiModelProperty(example = "null", required = true, value = "A note text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public CategorizedTextListInner type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The descriptive category of the text
   * @return type
  **/
  @ApiModelProperty(example = "null", required = true, value = "The descriptive category of the text")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategorizedTextListInner categorizedTextListInner = (CategorizedTextListInner) o;
    return Objects.equals(this.id, categorizedTextListInner.id) &&
        Objects.equals(this.text, categorizedTextListInner.text) &&
        Objects.equals(this.type, categorizedTextListInner.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategorizedTextListInner {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

