# Makefile for CS 455 extra credit assgt Fall 2018
#
#
#     make ectest
#        Makes ectest executable
#


CXXFLAGS = -ggdb -Wall
OBJS = ecListFuncs.o ectest.o


ectest: $(OBJS)
	$(CXX) $(CXXFLAGS) $(OBJS) -o ectest

$(OBJS): ecListFuncs.h
