package com.abstractionizer.Hello.World.model.vo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PageVo<T> {
    private Long total;
    private Long size;
    private Long current;
    private Long pages;
    private List<T> records;

    public PageVo(){
        this.total = 0L;
        this.size = 0L;
        this.current = 0L;
        this.pages = 0L;
        this.records = Collections.emptyList();
    }

    public PageVo(Long total, Long size, Long current, Long pages){
        this.total = total;
        this.size = size;
        this.current = current;
        this.pages = pages;
    }

    public PageVo(Long total, Long size, Long current, Long pages, List<T> records){
        this(total, size, current, pages);
        this.records = records;
    }

    public static <R> PageVo<R> of (PageVo<?> pageVo, List<R> records){
        return new PageVo<>(pageVo.total, pageVo.getSize(), pageVo.getCurrent(), pageVo.getPages(), records);
    }
}
