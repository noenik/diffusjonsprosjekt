ArrayList<rectangle> list = new ArrayList<rectangle>();

void setup() {
 size(440, 440);
 frameRate(5);
 int count = 0;
 for(int y = 0; y < height; y += 40) {
   count++;
  int aCount = 0; 
   for(int i = 0; i < width; i += 40) {
      aCount++;
      if(count == 6 && aCount == 6) {
        list.add(new rectangle(i, y, 10000));
      } else {
         list.add(new rectangle(i, y, 0));
      }   
    }
   for(rectangle r : list) {
    r.findNeighbours(list);
  }
 }
}


void draw() {
  background(255);
  
  int index = 0;
  for(rectangle r : list) {
   float xi = r.getXinit();
   float xe = r.getXinit() + 40;
   float yi = r.getYinit();
   float ye = r.getYinit() + 40;
    
    rect(xi, yi, xe, ye);
  
    for(int p = 0; p < r.getParticles(); p++) {
      set((int)random(xi + 1, xe - 1), (int)random(yi + 1, ye - 1), color(255,0,0));
      
      if(random(1) < 0.2) {
        moveParticle(index);
      }      
    }
    index++;
  }
}

void moveParticle(int index) {
  rectangle r = list.get(index);
  r.subP(1);
  
  rectangle receiver = r.randomNeighbour();
  receiver.addP(1);
}

int nextFree(int index){
  float randNum = random(1);
  
  if(index < 10 && randNum < 0.5) 
    return index + 1;
  else if(index < 10 && randNum > 0.5)
    return index + 10;
    
  if(index > 90 && randNum < 0.5) 
    return index - 1;
  else 
    return index - 10;
}

boolean hasIndex(int index) {
  
  if(index < 0) {
    return false;
  } else if (index > list.size() - 1) {
    return false;
  } else {
    return true;
  }
    
}

class rectangle {
  float xCoord;
  float yCoord;
  
  int particles;
  
  ArrayList<rectangle> neighbours = new ArrayList<rectangle>();
  
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
  
  rectangle randomNeighbour() {
    return neighbours.get((int) random(neighbours.size() - 1));
  }
  
  void findNeighbours(ArrayList<rectangle> rectangles) {
    for(rectangle r : rectangles) {
      float x = r.getXinit();
      float y = r.getYinit();
      if((x == xCoord - 40 && y == yCoord + 40) || (x == xCoord && y == yCoord + 40)
          || (x == xCoord + 40 && y == yCoord + 40) || (x == xCoord - 40 && y == yCoord)
          || (x == xCoord + 40 && y == yCoord) || (x == xCoord - 40 && y == yCoord - 40)
          || (x == xCoord && y == yCoord - 40) || (x == xCoord + 40 && y == yCoord - 40)) {
            neighbours.add(r);
          }
    }
    System.out.println(neighbours.size());
  }  
  
  void addP(int num) {
   particles += num; 
  }
  
  void subP(int num) {
   particles -= num;
  }
}
