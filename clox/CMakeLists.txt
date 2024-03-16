cmake_minimum_required(VERSION 3.28)
project(clox C)

set(CMAKE_C_STANDARD 11)

file(GLOB HEADERS *.h)
file(GLOB SOURCES *.c)

add_executable(clox main.c ${HEADERS} ${SOURCES})

target_include_directories(clox PRIVATE
        "${PROJECT_BINARY_DIR}"
)