#include <stdio.h>
#include <stdlib.h>
#include <GL/glew.h>
#include <GLFW/glfw3.h>


int main(int argc, char** argv) {
	printf("Hello world\n");
	if(!glfwInit()) {
		printf("Failed to initialize GLEW\n");
		return 1;
	}
	return 0;
}
