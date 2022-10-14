package com.example.form.Model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
@ToString
@Table(name = "BankCredit")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "credit", allocationSize = 1)
public class BankCredit {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cnp")
    @Length(min = 13, max = 13, message = "Introduceti un CNP valid!")
    private String cnp;

    @NotNull
    @Email(message = "Introduceti o adresa valida!")
    @Column(name = "email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "currency ")
    private Currency currency;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "creditType ")
    private CreditType creditType;

    /*
    valoare imprummut
     */
    @NotNull
    @Min(value=500, message = "Valoare imprumut prea mic!")
    @Max(value=1000000, message = "Valoare imprumut prea mare!")
    @Column(name = "money")
    private float money;

    /*
    prima rata
     */
    @NotNull
    @Column(name = "rate")
    private float rate;

    @NotNull
    @Column(name = "money_back")
    private float money_back;

    /*
    dobanda
     */
    @NotNull
    @Column(name = "credit_interest")
    private Integer credit_interest;

    /*
    tip dobanda
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "interestType ")
    private Interest interestType;

    /*
    * durata acreditare
    */
    @NotNull
    @Column(name = "duration ")
    private Integer duration;

}
