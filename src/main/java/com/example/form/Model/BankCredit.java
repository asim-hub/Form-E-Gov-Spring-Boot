package com.example.form.Model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "cnp")
    private String cnp;

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
    @Column(name = "money")
    private Integer money;

    /*
    prima rata
     */
    @NotNull
    @Column(name = "rate")
    private Integer rate;

    @NotNull
    @Column(name = "money_back")
    private Integer money_back;

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





}
