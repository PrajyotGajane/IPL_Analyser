package com.bridgelabz.IPL_Analyser.service;

import com.bridgelabz.IPL_Analyser.exception.IPLAnalyserException;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
      Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws IPLAnalyserException;
      List<E> getCSVFileList(Reader reader, Class csvClass) throws IPLAnalyserException;
}