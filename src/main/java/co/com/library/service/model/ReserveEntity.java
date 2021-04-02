package co.com.library.service.model;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserve", schema = "training", catalog = "")
public class ReserveEntity {

  private int id;
  private Date returnDate;
  private Integer cuantityBooks;
  private int idUser;
  private int idBook;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "return_date")
  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  @Basic
  @Column(name = "cuantity_books")
  public Integer getCuantityBooks() {
    return cuantityBooks;
  }

  public void setCuantityBooks(Integer cuantityBooks) {
    this.cuantityBooks = cuantityBooks;
  }

  @Basic
  @Column(name = "id_user")
  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  @Basic
  @Column(name = "id_book")
  public int getIdBook() {
    return idBook;
  }

  public void setIdBook(int idBook) {
    this.idBook = idBook;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReserveEntity that = (ReserveEntity) o;
    return id == that.id && idUser == that.idUser && idBook == that.idBook && Objects
        .equals(returnDate, that.returnDate) && Objects
        .equals(cuantityBooks, that.cuantityBooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, returnDate, cuantityBooks, idUser, idBook);
  }
}
