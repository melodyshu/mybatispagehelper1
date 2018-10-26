package com.fx;

import java.util.List;

public interface CityMapper {
    public City selectById(int id);
    public List<City> selectAll();
}
