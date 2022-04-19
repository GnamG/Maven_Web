package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface NoteService {
    ModelAndView view(ModelAndView mv, Integer noteId, HttpServletRequest req);
}
