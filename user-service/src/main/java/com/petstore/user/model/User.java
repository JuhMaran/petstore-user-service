package com.petstore.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * {@code @Document(indexName = "users")}: Define o índice do Elasticsearch.
 * {@code @Id}: Identifica o campo que será o _id do documento no Elasticsearch. <br>
 * {@code @Field}: define o tipo de campo no Elasticsearch <br>
 * - keyword: ideal para buscas exatas, filtros e agregações <br>
 * - Text: ideal para busca full-text <br>
 * - Integer, Long: tipos numéricos
 *
 * @author Juliane Maran
 * @since 09/01/2026
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "users")
public class User {

  @Id
  private Long id;

  @Field(type = FieldType.Keyword)
  private String username;

  @Field(type = FieldType.Text)
  private String firstName;

  @Field(type = FieldType.Text)
  private String lastName;

  @Field(type = FieldType.Keyword)
  private String email;

  @Field(type = FieldType.Keyword)
  private String phoneNumber;

  @Field(type = FieldType.Integer)
  private Integer userStatus;

}
