package co.com.library.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "books")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BooksEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name = "bookname")
  String bookName;

  @Column(name = "author")
  String author;

  @Column(name = "category")
  String category;

  @Column(name = "cuantity_available")
  Integer cuantityAvailable;

  @Column(name = "reserved_amount")
  Integer reservedAmount;

  @Column(name = "rate")
  Integer rate;
}
