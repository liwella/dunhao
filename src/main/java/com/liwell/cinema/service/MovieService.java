package com.liwell.cinema.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liwell.cinema.domain.dto.IdDTO;
import com.liwell.cinema.domain.dto.MvAddDTO;
import com.liwell.cinema.domain.dto.MvPageDTO;
import com.liwell.cinema.domain.entity.Movie;
import com.liwell.cinema.domain.vo.MovieDetailVO;
import com.liwell.cinema.domain.vo.MvPageVO;

import java.util.List;

/**
 * Description:
 *
 * @author Li
 * @date Created on 2023/1/24
 */
public interface MovieService extends IService<Movie> {

    Page<MvPageVO> pageMovie(MvPageDTO mvPageDTO);

    MovieDetailVO getMovieDetail(IdDTO dto);

    Boolean addOrUpdate(MvAddDTO dto);

    Boolean deleteMovie(IdDTO dto);

    List<Integer> listNonSourceMovie();

}
