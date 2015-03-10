ArrayList<rectangle> list = new ArrayList<rectangle>();
particle p;

void setup() {
 size(441, 41);
 
  int aCount = 0; 
   for(int i = 0; i < width; i += 40) {
      list.add(new rectangle(i, 0, aCount));
      aCount++; 
    }
    
   for(rectangle r : list) {
    r.findNeighbours(list);
  }
  
  p = new particle();
 
}


void draw() {
  background(255);
  
  ellipseMode(CENTER);
  
  
  
  fill(255);
  for(rectangle r : list) {
   float xi = r.getXinit();
   float xe = r.getXinit() + 40;
   float yi = r.getYinit();
   float ye = r.getYinit() + 40;
    
   rect(xi, yi, xe, ye);
  
  }
  
  fill(255, 0, 0);
  ellipse(p.getX(), p.getY(), 20, 20);
  p.move();
  if(frameCount % 60 == 0) {
    p.newSquare();
  }
  
}

class particle {
 float xCoord;
 float yCoord;
 int currentSquare;
 int factor;
 
 particle() {
  currentSquare = 6;
  xCoord = 20 * currentSquare;
  yCoord = 20;
  factor = 40;
 } 
 
 float getX() {
   return xCoord;
 }
 
 float getY() {
   return yCoord;
 }
 
 void move () {
   xCoord = (factor * currentSquare + random(2) - 1) - 20;
   yCoord += random(2) - 1;
   
   if(yCoord < 0) {
     yCoord++;
   } else if(yCoord > 40) {
     yCoord--;
   }
   
   if(xCoord < 0) {
     xCoord++;
   } else if(xCoord > 440) {
     xCoord--;
   }
 }
 
 void setFactor(int factor) {
   this.factor = factor;
 }

void newSquare() {
  float randNum = random(1);
  
  if(randNum < 0.34) {
    currentSquare--;
  } else if(randNum > 0.67) {
    currentSquare++;
  }
}
}

class rectangle {
  float xCoord;
  float yCoord;
  int num;
  
  ArrayList<rectangle> neighbours = new ArrayList<rectangle>();
  
  rectangle(float x, float y, int num) {
   xCoord = x;
   yCoord = y;
   this.num = num;
  } 
  
  float getXinit() {
   return xCoord; 
  }
  
  float getYinit() {
   return yCoord; 
  }
  
  int getNum() {
   return num; 
  }
  
  rectangle randomNeighbour() {
    return neighbours.get((int) random(neighbours.size() - 1));
  }
  
  void findNeighbours(ArrayList<rectangle> rectangles) {
    for(rectangle r : rectangles) {
      if(r.getNum() == num + 1 && r.getNum() == num - 1) {
            neighbours.add(r);
          }
    }
  }
} 

