# Hibernate/JPA playground for various stuff

### `@see SomeTests#selectIndicesFromTernaryRelation()`

https://hibernate.atlassian.net/browse/HHH-14475

Generated SQL from `select indices(p.roles) from Person p`

* is ok in 5.4.12.Final:
```
    select
        roles1_.project_id as col_0_0_ 
    from
        person person0_ cross 
    join
        person_to_role roles1_ 
    where
        person0_.id=roles1_.person_id;
```

* but broken in 5.4.13.Final:
```
    select
        select
            roles1_.project_id 
        from
            person_to_role roles1_ 
        where
            person0_.id=roles1_.person_id as col_0_0_ 
        from
            person person0_ cross 
        join
            person_to_role roles1_ 
        where
            person0_.id=roles1_.person_id;
```
