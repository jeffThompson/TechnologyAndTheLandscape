import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class VisualizeGPX extends PApplet {




/*
VISUALIZE GPX
Jeff Thompson | 2016 | jeffreythompson.org

A sketch that parses a GPX file (the most common
format for GPS logging) and visualizes the tracks.

Outputs two versions as both PDF and images:
- one with simple black lines (easy to manipulate
  later in Illustrator)
- one with gradient lines showing elevation

Gradient line code via:
https://forum.processing.org/two/discussion/5620/
how-to-draw-a-gradient-colored-line

*/


int outputWidth =   2400;                // max size for output file
int outputHeight =  2400;
int margin =        200;                 // space around the track
int lineThickness = 6;                   // thickness for line

int lowColor =    color(0,150,255);    // color of lowest elevation
int highColor =   color(255,150,0);    // ditto highest


XML xml;
ArrayList<PVector> points;
float minLat = MAX_FLOAT;
float maxLat = MIN_FLOAT;
float minLon = MAX_FLOAT;
float maxLon = MIN_FLOAT;
float minEle = MAX_FLOAT;
float maxEle = MIN_FLOAT;
String inputFilename, outputFilename;
PGraphics output;


public void setup() {
  
  surface.setResizable(true);
  
  selectInput("Select a GPX file...", "selectGPX");
}


public void draw() {
  if (inputFilename != null) {
    points = loadData();        // loads as lon, lat, and elevation
    
    // find min/max values for drawing
    // (for some reason, needs redundant checking, gross)
    for (PVector p : points) {
      if (p.x < minLon) minLon = p.x;
      else if (p.x > maxLon) maxLon = p.x;
      
      if (p.y < minLat) minLat = p.y;
      else if (p.y > maxLat) maxLat = p.y;
      
      if (p.z < minEle) minEle = p.z;
      else if (p.z > maxEle) maxEle = p.z;
    }

    // set width/height proportionally to track
    float w = maxLon - minLon;
    float h = maxLat - minLat;
    println(minLat, maxLat);
    float ratio = w / h;
    println(ratio);
    output = createGraphics(outputWidth, ceil(outputWidth / ratio), PDF, outputFilename + ".pdf");
    println(output.width, output.height);
      
    // update points to screen coords
    for (PVector p : points) {
      if (p.y > maxLat) println(p.y + " (" + maxLat + ")");
      p.x = map(p.x, minLon, maxLon, margin, output.width-margin);
      p.y = map(p.y, maxLat, minLat, margin, output.height-margin);    // reverse direction
      p.z = map(p.z, minEle, maxEle, 0,1);
    }

    // draw it
    output.beginDraw();
    output.noFill();
    output.stroke(0);
    output.strokeWeight(lineThickness);
    PVector prev = points.get(0);
    for (PVector p : points) {
      output.line(p.x, p.y, prev.x, prev.y);
      prev = p;
    }
    output.endDraw();
    output.dispose();
    
    // and with elevation gradient
    output = createGraphics(outputWidth, PApplet.parseInt(outputWidth / ratio), PDF, outputFilename + "-ELEVATION.pdf");
    output.beginDraw();
    output.noStroke();
    prev = points.get(0);
    for (PVector p : points) {
      int startColor = lerpColor(lowColor, highColor, prev.z);
      int endColor = lerpColor(lowColor, highColor, p.z);
      gradientLine(p, prev, startColor, endColor);
      prev = p;
    }
    output.endDraw();
    output.dispose();
    
    // all done, bye!
    exit();
  }  
}


// open GPX file and get filename for output
public void selectGPX(File sel) {
  if (sel == null) {
    exit();
  } 
  else if (!sel.getAbsolutePath().endsWith(".gpx")) {
    exit();
  }
  else {
    inputFilename = sel.getAbsolutePath();
    outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf('.'));
  }
}


// load the data from the GPX file
public ArrayList<PVector> loadData() {
  points = new ArrayList<PVector>();

  xml = loadXML(inputFilename);
  XML track = xml.getChild("trk");
  XML[] segments = track.getChildren("trkseg");

  for (XML segment : segments) {
    XML[] trackpoints = segment.getChildren("trkpt");
    
    for (XML trackpoint : trackpoints) {
      float lon = trackpoint.getFloat("lon");
      if (lon < minLon) minLon = lon;
      else if (lon > maxLon) maxLon = lon;
      
      float lat = trackpoint.getFloat("lat");      
      if (lat < minLat) minLat = lat;
      else if (lat > maxLat) maxLat = lat;
      
      float ele =  trackpoint.getChild("ele").getFloatContent();
      if (ele < minEle) minEle = ele;
      else if (ele > maxEle) maxEle = ele;
      
      points.add(new PVector(lon, lat, ele));
    }
  }
  return points;
}


// draw a gradient line
// via: https://forum.processing.org/two/discussion/5620/
// how-to-draw-a-gradient-colored-line
public void gradientLine(PVector p, PVector prev, int a, int b) {
  float deltaX = prev.x - p.x;
  float deltaY = prev.y - p.y;
  float inc = 1.0f / dist(p.x, p.y, prev.x, prev.y);
  for (float i=0; i<1; i+=inc) {
    output.fill(lerpColor(a, b, i));
    output.noStroke();
    output.ellipse(p.x + i*deltaX, p.y + i*deltaY, lineThickness,lineThickness);
  }
}
  public void settings() {  size(100,100); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "VisualizeGPX" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
