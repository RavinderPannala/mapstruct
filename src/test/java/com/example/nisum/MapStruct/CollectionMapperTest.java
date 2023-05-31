package com.example.nisum.MapStruct;

import com.example.nisum.MapStruct.mapper.CollectionMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CollectionMapperTest {

    private CollectionMapper mapper = Mappers.getMapper(CollectionMapper.class);

    @Test
    public void testSet() {
        Set<Long> set = new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        Set<String> convert = mapper.convert(set);
        assertEquals(set.size(),convert.size());
    }
}
