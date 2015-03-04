ArrayList<rectangle> list = new ArrayList<rectangle>();

void setup() {
 size(400, 400);
 int count = 0;
 for(int y = 0; y < height; y += 40) {
   count++;
  int aCount = 0; 
   for(int i = 0; i < width; i += 40) {
      aCount++;
      if(count == 4 && aCount == 4) {
        list.add(new rectangle(i, y, 100));
      } else {
         list.add(new rectangle(i, y, 0));
      }   
    }  
  }
}


void draw() {
  background(255);
  
  
  
  for(rectangle r : list) {
   float xi = r.getXinit();
   float xe = r.getXinit() + 40;
   float yi = r.getYinit();
   float ye = r.getYinit() + 40;
    
    rect(xi, yi, xe, ye);
  
    for(int p = 0; p < r.getParticles(); p++) {
      set((int)random(xi + 1, xe - 1), (int)random(yi + 1, ye - 1), color(255,0,0));
    }
  }
}

class rectangle {
  float xCoord;
  float yCoord;
  
  int particles;
  
  rectangle(float x, float y, int particles) {
   xCoord = x;
   yCoord = y;
   this.particles = particles;
  } 
  
  float getXinit() {
   return xCoord; 
  }
  
  float getYinit() {
   return yCoord; 
  }
  
  int getParticles() {
   return particles; 
  }
}
