package kr.co.springboot_was_base.common.util.model;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ModelUtil {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> T copy(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> targetClass) {
        return sourceList
                .stream()
                .map(sourceElement -> modelMapper.map(sourceElement, targetClass))
                .collect(Collectors.toList());
    }

}
