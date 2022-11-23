package net.e4net.demo.security;

import org.modelmapper.ModelMapper;

/**
 * ModelMapper는 기본적으로 source class가 null인 경우에 throw exception을 발생 시킨다.
 * 그래서 해당 ModelMapper의 map 메소드를 오버라이드 해서, 기본 오브젝트로 생성 되도록 처리
 *
 * ModelMapper.map() 메소드를 오버라이드 처리한 CustomModelMapper를 bean으로 등록하여
 * 위에 설명한 사용법을 사용하면, Source Object 가 null 일 경우에도 Exception 없이 Target Object를 얻어 낼 수 있다.
 */
public class CustomModelMapper extends ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        Object tmpSource = source;
        if(source == null){
            tmpSource = new Object();	// 기본 생성자로 생성 처리
        }

        return super.map(tmpSource, destinationType);
    }

}