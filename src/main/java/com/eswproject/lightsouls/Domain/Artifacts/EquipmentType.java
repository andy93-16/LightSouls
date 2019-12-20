package com.eswproject.lightsouls.Domain.Artifacts;


public enum EquipmentType
{
        Arma,
        Armatura;

        public Class EquipmentClass()
        {
            try
            {
                String eqclassname = this.getClass().getPackage().getName()+"."+this.name();
                Class equipmentClass = Class.forName(eqclassname);
                return equipmentClass;
            }
            catch (ClassNotFoundException c)
            {
                System.out.println(c);
            }
            return null;
        }
}