package com.app.shop.entity.cart;

import com.app.shop.entity.BaseEntity;
import com.app.shop.entity.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "cart")
@Entity
public class Cart extends BaseEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Cart(Member member) {
        this.member = member;
    }

    public static Cart createCart(Member member) {
        Cart cart = Cart.builder()
                .member(member)
                .build();

        return cart;
    }


}
