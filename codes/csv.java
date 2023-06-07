 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String linea="";
        File archivo = new File ("C:\\Users\\luisr\\OneDrive\\Documentos\\csv\\micsv.csv");
        FileReader archivoLector;
        try {
            archivoLector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(archivoLector);
            while ((linea= buffer.readLine())!=null){
                String arreglo [] = linea.split(",");
                System.out.print( arreglo[0]+"-");
                System.out.println( arreglo[1]);
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
