package com.pw.projetofinal.domain.generic;


@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor

public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private long id;

}