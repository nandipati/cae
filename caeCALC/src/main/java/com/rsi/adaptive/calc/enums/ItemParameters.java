package com.rsi.adaptive.calc.enums;

/**
 * Created by suryadevarap on 12/21/18.
 */
public enum ItemParameters {

  DISCRIMINATOR(new double[]{0.7573722, 0.84344208, 0.91272306, 0.8476324, 0.75653338, 0.91264614, 1.7310894,
                             0.93499608,1.54515682, 1.24897604, 0.71757726, 1.00732102, 1.03585051, 0.81302008,
                             0.94757159,0.59698281,0.62028276, 1.00758979, 0.58312897, 0.60219414, 0.66084336,
                             0.62989076, 0.70693752,0.86574777,0.61312122, 0.56735134, 0.98809429, 0.53907226,
                             0.64132853, 0.67836688,0.92011339,0.83107679,0.87903698, 1.43258799, 0.44561383,
                             1.03101111, 1.6025383, 0.85904148,1.55120193,0.8282011 }),

  DIFFICULTY(new double[]{1.6230173, 0.67152368, -0.32696466, -0.01087341, -0.12937667, 0.80500481, 1.29248633,
                          1.06740232, -0.14137442, 0.59466423, 0.19875489, 2.02049419, 1.14622086, -0.60786305,
                          0.52960921, 0.12096465, 0.49659716, 1.13475338, -1.6020013, 1.10518653, -0.10679459,
                          -0.59138503, 1.88745664, 0.7035784, -0.30082617, -1.492581, 1.95993867, 0.21187485,
                          0.59263333, 2.09225317, 0.17273864, 0.82048979, 0.71126868, 0.31175695, 0.82426725,
                          1.87676213, 2.16970874, 1.0654643, 1.81675684, 0.17928933});

  public double[] getParam() {
    return param;
  }

  private double[] param;

  ItemParameters(double[] param){
     this.param=param;
   }


}
