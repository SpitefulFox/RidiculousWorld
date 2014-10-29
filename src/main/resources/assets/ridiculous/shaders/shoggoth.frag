#version 120

varying vec2 texcoord;
uniform sampler2D bgl_RenderedTexture;
uniform int time; // Passed in, see ShaderHelper.java

uniform float grainIntensity; // Passed in via Callback
uniform float pain; // Passed in via Callback

float rand(vec2 co) {
	return fract(sin(dot(co.xy, vec2(12.9898,78.233))) * 43758.5453);
}

void main() {
	vec4 color = texture2D(bgl_RenderedTexture, texcoord);
	
	//float gs = (color.r + color.g + color.b) / 50.0;
	
	vec2 seed = texcoord.xy * time;
	vec2 seed2 = texcoord.xy * (time + 1);
	vec2 seed3 = texcoord.xy * (time - 1);
	
	float r = color.r + rand(seed) * grainIntensity + pain * 0.01;
	float g = color.g + rand(seed2) * grainIntensity - pain * 0.02;
	float b = color.b + rand(seed3) * grainIntensity - pain * 0.02;
	
	gl_FragColor = vec4(r, g, b, color.a);
	//gl_FragColor = color;
}